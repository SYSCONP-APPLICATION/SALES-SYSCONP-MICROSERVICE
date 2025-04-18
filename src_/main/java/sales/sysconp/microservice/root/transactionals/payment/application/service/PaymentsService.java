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
import sales.sysconp.microservice.features.payment.domain.models.PaymentModel;
import sales.sysconp.microservice.root.transactionals.payment.application.dto.CreatePaymentsRequestDTO;
import sales.sysconp.microservice.root.transactionals.payment.application.ports.in.PaymentsServiceInPort;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PaymentsService implements PaymentsServiceInPort {
    private final PaymentService paymentService;
    private final DebtService debtService;
    private final DebtRepositoryAdapter debtRepositoryAdapter;
    private final InstallmentRepositoryAdapter installmentRepositoryAdapter;

    public PaymentsService(PaymentService paymentService, DebtService debtService, DebtRepositoryAdapter debtRepositoryAdapter, InstallmentRepositoryAdapter installmentRepositoryAdapter) {
        this.paymentService = paymentService;
        this.installmentRepositoryAdapter = installmentRepositoryAdapter;
        this.debtRepositoryAdapter = debtRepositoryAdapter;
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

        // Validar se todos os installmentId são iguais
        Long referenceInstallmentId = payments.get(0).getInstallmentId();
        boolean allSameInstallment = payments.stream()
                .allMatch(p -> p.getInstallmentId().equals(referenceInstallmentId));
        if (!allSameInstallment) {
            throw new IllegalArgumentException("All payments must belong to the same installment.");
        }

        // Recuperar o installment uma única vez
        InstallmentModel installment = installmentRepositoryAdapter.findById(referenceInstallmentId)
                .orElseThrow(() -> new NoSuchElementException("Installment not found with id: " + referenceInstallmentId));

        // Verificar o valor total que precisa ser pago
        double requiredTotal = installment.getValue();
        if (installment.getDebt() != null) {
            requiredTotal += installment.getDebt().getDebtValue();
        }

        // Soma de todos os pagamentos recebidos na requisição
        double totalRequestedPayment = payments.stream().mapToDouble(PaymentCreateRequestDTO::getValue).sum();

        if (Double.compare(totalRequestedPayment, requiredTotal) != 0) {
            throw new IllegalArgumentException("The total payment must be exactly equal to the installment value plus any debt. Expected: " + requiredTotal + ", but got: " + totalRequestedPayment);
        }

        // Registrar todos os pagamentos
        for (PaymentCreateRequestDTO payment : payments) {
            paymentService.createPayment(payment);
        }

        // Se for NO_DEBT, não faz nada com dívidas
        if (referenceProcess == PaymentProcessEnum.NO_DEBT) {
            return;
        }

        // Se houver dívida, trata conforme o processo
        if (installment.getDebt() != null) {
            DebtModel debt = installment.getDebt();

            if (debt.getDebtPayedAt() != null || debt.getForgivenAt() != null) {
                return; // já tratada
            }

            if (referenceProcess == PaymentProcessEnum.PAY_DEBT) {
                debtService.payDebt(debt.getId(), payments.get(0).getUserId());
            } else if (referenceProcess == PaymentProcessEnum.FORGIVE_DEBT) {
                debtService.forgiveDebt(debt.getId(), payments.get(0).getUserId());
            }
        }
    }
}