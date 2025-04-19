package sales.sysconp.microservice.root.transactionals.payment.application.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sales.sysconp.microservice.features.debt.application.services.DebtService;
import sales.sysconp.microservice.features.debt.domain.models.DebtModel;
import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;
import sales.sysconp.microservice.features.installment.infrastructure.repository.InstallmentRepositoryAdapter;
import sales.sysconp.microservice.features.payment.application.dto.PaymentCreateRequestDTO;
import sales.sysconp.microservice.features.payment.application.services.PaymentService;
import sales.sysconp.microservice.features.payment.domain.enums.PaymentProcessEnum;
import sales.sysconp.microservice.features.sale.application.dto.SaleUpdateRequestDTO;
import sales.sysconp.microservice.features.sale.application.services.SaleService;
import sales.sysconp.microservice.features.sale.domain.enums.SaleStatus;
import sales.sysconp.microservice.features.sale.infrastructure.repository.SaleRepositoryAdapter;
import sales.sysconp.microservice.root.transactionals.payment.application.dto.CreatePaymentsRequestDTO;
import sales.sysconp.microservice.root.transactionals.payment.application.ports.in.PaymentsServiceInPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PaymentsService implements PaymentsServiceInPort {
    private final PaymentService paymentService;
    private final DebtService debtService;
    private final InstallmentRepositoryAdapter installmentRepositoryAdapter;
    private final SaleRepositoryAdapter saleRepositoryAdapter;
    private final SaleService saleService;

    public PaymentsService(PaymentService paymentService, SaleService saleService, DebtService debtService, InstallmentRepositoryAdapter installmentRepositoryAdapter, SaleRepositoryAdapter saleRepositoryAdapter) {
        this.paymentService = paymentService;
        this.installmentRepositoryAdapter = installmentRepositoryAdapter;
        this.debtService = debtService;
        this.saleService = saleService;
        this.saleRepositoryAdapter = saleRepositoryAdapter;
    }

    @Transactional
    @Override
    public void createPayments(CreatePaymentsRequestDTO requestDTO) {
        List<PaymentCreateRequestDTO> payments = requestDTO.getPaymentCreateRequestDTO();

        if (CollectionUtils.isEmpty(payments)) {
            throw new IllegalArgumentException("Payments list cannot be empty.");
        }

        PaymentProcessEnum referenceProcess = payments.get(0).getPaymentProcess();
        boolean allSameProcess = payments.stream()
                .allMatch(p -> p.getPaymentProcess() == referenceProcess);

        if (!allSameProcess) {
            throw new IllegalArgumentException("All payments must have the same payment process.");
        }

        Map<Long, List<PaymentCreateRequestDTO>> paymentsByInstallment = payments.stream()
                .collect(Collectors.groupingBy(PaymentCreateRequestDTO::getInstallmentId));

        Long saleIdReference = null;

        for (Map.Entry<Long, List<PaymentCreateRequestDTO>> entry : paymentsByInstallment.entrySet()) {
            Long installmentId = entry.getKey();
            List<PaymentCreateRequestDTO> installmentPayments = entry.getValue();

            InstallmentModel installment = installmentRepositoryAdapter.findById(installmentId)
                    .orElseThrow(() -> new NoSuchElementException("Installment not found with id: " + installmentId));

            if (saleIdReference == null) {
                saleIdReference = installmentPayments.get(0).getSaleId();
            }

            double requiredTotal = installment.getValue();
            if (installment.getDebt() != null) {
                requiredTotal += installment.getDebt().getDebtValue();
            }

            double totalPaid = installmentPayments.stream()
                    .mapToDouble(PaymentCreateRequestDTO::getValue)
                    .sum();

            if (Double.compare(totalPaid, requiredTotal) != 0) {
                throw new IllegalArgumentException(
                        "Installment of " + installment.getMonth() +
                                " expected payment of " + requiredTotal +
                                ", but received " + totalPaid
                );
            }

            // Registrar pagamentos
            for (PaymentCreateRequestDTO payment : installmentPayments) {
                paymentService.createPayment(payment);
            }

            // Atualizar apenas o campo paidAt via query personalizada
            installmentRepositoryAdapter.updatePaidAt(installment.getId(), LocalDateTime.now());

            // Processar dívida, se necessário
            if (referenceProcess != PaymentProcessEnum.NO_DEBT) {
                DebtModel debt = installment.getDebt();

                if (debt != null && debt.getDebtPayedAt() == null && debt.getForgivenAt() == null) {
                    Long userId = installmentPayments.get(0).getUserId();
                    if (referenceProcess == PaymentProcessEnum.PAY_DEBT) {
                        debtService.payDebt(debt.getId(), userId);
                    } else if (referenceProcess == PaymentProcessEnum.FORGIVE_DEBT) {
                        debtService.forgiveDebt(debt.getId(), userId);
                    }
                }
            }
        }

        // Verifica se todas as parcelas foram pagas
        if (saleIdReference != null) {
            List<InstallmentModel> unpaidInstallments =
                    installmentRepositoryAdapter.findBySaleIdAndPaidAtIsNull(saleIdReference);

            if (unpaidInstallments.isEmpty()) {
                SaleUpdateRequestDTO saleUpdateRequestDTO = new SaleUpdateRequestDTO();
                saleUpdateRequestDTO.setStatus(SaleStatus.COMPLETED);
                saleService.updateSale(saleIdReference, saleUpdateRequestDTO);
            }
        }
    }
}