package sales.sysconp.microservice.root.transactionals.payment.application.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sales.sysconp.microservice.features.debt.application.services.DebtService;
import sales.sysconp.microservice.features.debt.domain.models.DebtModel;
import sales.sysconp.microservice.features.debt.infrastructure.repository.DebtRepositoryAdapter;
import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;
import sales.sysconp.microservice.features.installment.infrastructure.repository.InstallmentRepositoryAdapter;
import sales.sysconp.microservice.features.payment.application.dto.PaymentCreateRequestDTO;
import sales.sysconp.microservice.features.payment.application.services.PaymentService;
import sales.sysconp.microservice.features.payment.domain.enums.PaymentProcessEnum;
import sales.sysconp.microservice.root.transactionals.payment.application.dto.CreatePaymentsRequestDTO;
import sales.sysconp.microservice.root.transactionals.payment.application.ports.in.PaymentsServiceInPort;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PaymentsService implements PaymentsServiceInPort {
    private final PaymentService paymentService;
    private final DebtService debtService;
    private final InstallmentRepositoryAdapter installmentRepositoryAdapter;

    public PaymentsService(PaymentService paymentService, DebtService debtService, InstallmentRepositoryAdapter installmentRepositoryAdapter) {
        this.paymentService = paymentService;
        this.installmentRepositoryAdapter = installmentRepositoryAdapter;
        this.debtService = debtService;
    }

    @Transactional
    @Override
    public void createPayments(CreatePaymentsRequestDTO requestDTO) {
        List<PaymentCreateRequestDTO> payments = requestDTO.getPaymentCreateRequestDTO();

        if (CollectionUtils.isEmpty(payments)) {
            throw new IllegalArgumentException("Payments list cannot be empty.");
        }

        // Validar se todos os paymentProcess são iguais
        PaymentProcessEnum referenceProcess = payments.get(0).getPaymentProcess();
        boolean allSameProcess = payments.stream()
                .allMatch(p -> p.getPaymentProcess() == referenceProcess);
        if (!allSameProcess) {
            throw new IllegalArgumentException("All payments must have the same payment process.");
        }

        // Agrupar pagamentos por parcela (installmentId)
        Map<Long, List<PaymentCreateRequestDTO>> paymentsByInstallment = payments.stream()
                .collect(Collectors.groupingBy(PaymentCreateRequestDTO::getInstallmentId));

        for (Map.Entry<Long, List<PaymentCreateRequestDTO>> entry : paymentsByInstallment.entrySet()) {
            Long installmentId = entry.getKey();
            List<PaymentCreateRequestDTO> installmentPayments = entry.getValue();

            InstallmentModel installment = installmentRepositoryAdapter.findById(installmentId)
                    .orElseThrow(() -> new NoSuchElementException("Installment not found with id: " + installmentId));

            // Valor total necessário (parcela + dívida, se houver)
            double requiredTotal = installment.getValue();
            if (installment.getDebt() != null) {
                requiredTotal += installment.getDebt().getDebtValue();
            }

            // Soma dos pagamentos para essa parcela
            double totalPaid = installmentPayments.stream()
                    .mapToDouble(PaymentCreateRequestDTO::getValue)
                    .sum();

            // Verifica se o pagamento é completo
            if (Double.compare(totalPaid, requiredTotal) != 0) {
                throw new IllegalArgumentException(
                        "Installment " + installmentId +
                                " expected payment of " + requiredTotal +
                                ", but received " + totalPaid
                );
            }

            // Registra os pagamentos
            for (PaymentCreateRequestDTO payment : installmentPayments) {
                paymentService.createPayment(payment);
            }

            // Se for NO_DEBT, não trata dívida
            if (referenceProcess == PaymentProcessEnum.NO_DEBT) {
                continue;
            }

            // Se houver dívida, trata conforme o processo
            DebtModel debt = installment.getDebt();
            if (debt != null && debt.getDebtPayedAt() == null && debt.getForgivenAt() == null) {
                if (referenceProcess == PaymentProcessEnum.PAY_DEBT) {
                    debtService.payDebt(debt.getId(), installmentPayments.get(0).getUserId());
                } else if (referenceProcess == PaymentProcessEnum.FORGIVE_DEBT) {
                    debtService.forgiveDebt(debt.getId(), installmentPayments.get(0).getUserId());
                }
            }
        }
    }
}