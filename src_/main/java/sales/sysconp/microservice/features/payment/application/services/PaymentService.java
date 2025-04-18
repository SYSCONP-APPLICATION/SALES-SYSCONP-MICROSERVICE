package sales.sysconp.microservice.features.payment.application.services;

import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.bank.domain.models.BankModel;
import sales.sysconp.microservice.features.bank.infrastructure.repository.BankRepositoryAdapter;
import sales.sysconp.microservice.features.debt.application.services.DebtService;
import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;
import sales.sysconp.microservice.features.installment.infrastructure.repository.InstallmentRepositoryAdapter;
import sales.sysconp.microservice.features.payment.application.dto.PaymentCreateRequestDTO;
import sales.sysconp.microservice.features.payment.application.dto.PaymentResponseDTO;
import sales.sysconp.microservice.features.payment.application.ports.in.PaymentServiceInPort;
import sales.sysconp.microservice.features.payment.domain.enums.PaymentProcessEnum;
import sales.sysconp.microservice.features.payment.domain.mappers.PaymentMapper;
import sales.sysconp.microservice.features.payment.domain.models.PaymentModel;
import sales.sysconp.microservice.features.payment.infrastructure.repository.PaymentRepositoryAdapter;
import sales.sysconp.microservice.features.payment_method.domain.models.PaymentMethodModel;
import sales.sysconp.microservice.features.payment_method.infrastructure.repository.PaymentMethodRepositoryAdapter;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.features.sale.infrastructure.repository.SaleRepositoryAdapter;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.repository.CompanyRepositoryAdapter;
import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;
import sales.sysconp.microservice.modules.auth.user.infrastructure.repository.UserRepositoryAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class PaymentService implements PaymentServiceInPort {
    private final PaymentMethodRepositoryAdapter paymentMethodRepositoryAdapter;
    private final SaleRepositoryAdapter saleRepositoryAdapter;
    private final InstallmentRepositoryAdapter installmentRepositoryAdapter;
    private final BankRepositoryAdapter bankRepositoryAdapter;
    private final CompanyRepositoryAdapter companyRepositoryAdapter;
    private final UserRepositoryAdapter userRepositoryAdapter;
    private final PaymentRepositoryAdapter paymentRepositoryAdapter;
    private final PaymentMapper paymentMapper;
    private final DebtService debtService;

    public PaymentService(
            DebtService debtService,
            PaymentMethodRepositoryAdapter paymentMethodRepositoryAdapter,
            SaleRepositoryAdapter saleRepositoryAdapter,
            InstallmentRepositoryAdapter installmentRepositoryAdapter,
            BankRepositoryAdapter bankRepositoryAdapter,
            CompanyRepositoryAdapter companyRepositoryAdapter,
            UserRepositoryAdapter userRepositoryAdapter,
            PaymentRepositoryAdapter paymentRepositoryAdapter,
            PaymentMapper paymentMapper
    ) {
        this.debtService = debtService;
        this.paymentMethodRepositoryAdapter = paymentMethodRepositoryAdapter;
        this.saleRepositoryAdapter = saleRepositoryAdapter;
        this.installmentRepositoryAdapter = installmentRepositoryAdapter;
        this.bankRepositoryAdapter = bankRepositoryAdapter;
        this.companyRepositoryAdapter = companyRepositoryAdapter;
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.paymentRepositoryAdapter = paymentRepositoryAdapter;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public PaymentResponseDTO getPaymentById(Long id) {
        return paymentRepositoryAdapter.findById(id)
                .map(paymentMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Payment not found with id: " + id));
    }

    @Override
    public PaymentResponseDTO getPaymentByUUID(UUID uuid) {
        return paymentRepositoryAdapter.findByUUID(uuid)
                .map(paymentMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Payment not found with uuid: " + uuid));
    }

    @Override
    public List<PaymentResponseDTO> getPaymentsBySaleId(Long saleId) {
        this.saleRepositoryAdapter
                .findById(saleId)
                .orElseThrow(() -> new NoSuchElementException("Sale not found with id: " + saleId));

        return paymentRepositoryAdapter.findAllBySaleId(saleId)
                .stream()
                .map(paymentMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<PaymentResponseDTO> getPaymentsByCompanyId(Long companyId) {
        this.companyRepositoryAdapter
                .findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company not found with id: " + companyId));

        return paymentRepositoryAdapter.findAllByCompanyId(companyId)
                .stream()
                .map(paymentMapper::toResponseDTO)
                .toList();
    }

    @Override
    public PaymentResponseDTO createPayment(PaymentCreateRequestDTO paymentCreateRequestDTO) {
        // PAYMENT METHOD
        PaymentMethodModel paymentMethod = paymentMethodRepositoryAdapter.findById(paymentCreateRequestDTO.getPaymentMethodId())
                .orElseThrow(() -> new NoSuchElementException("Payment method not found with id: " + paymentCreateRequestDTO.getPaymentMethodId()));

        // SALE
        SaleModel sale = saleRepositoryAdapter.findById(paymentCreateRequestDTO.getSaleId())
                .orElseThrow(() -> new NoSuchElementException("Sale not found with id: " + paymentCreateRequestDTO.getSaleId()));

        // INSTALLMENT
        InstallmentModel installment = installmentRepositoryAdapter.findById(paymentCreateRequestDTO.getInstallmentId())
                .orElseThrow(() -> new NoSuchElementException("Installment not found with id: " + paymentCreateRequestDTO.getInstallmentId()));

//         VALIDATE IF INSTALLMENT ALREADY HAS PAYMENTS
        if (installment.getPayments() != null && !installment.getPayments().isEmpty()) {
            throw new IllegalArgumentException("Installment already has payments.");
        }

        // BANK
        BankModel bank = bankRepositoryAdapter.findById(paymentCreateRequestDTO.getBankId());
        if (bank == null) {
            throw new NoSuchElementException("Bank not found with id: " + paymentCreateRequestDTO.getBankId());
        }

        // COMPANY
        CompanyModel company = companyRepositoryAdapter.findById(paymentCreateRequestDTO.getCompanyId())
                .orElseThrow(() -> new NoSuchElementException("Company not found with id: " + paymentCreateRequestDTO.getCompanyId()));

        // USER
        UserModel user = userRepositoryAdapter.findById(paymentCreateRequestDTO.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + paymentCreateRequestDTO.getUserId()));

        // VALIDATE PAYMENT PROCESS
        boolean hasDebt = installment.getDebt() != null;
        PaymentProcessEnum process = paymentCreateRequestDTO.getPaymentProcess();

        if (hasDebt) {
            if (process == PaymentProcessEnum.NO_DEBT) {
                throw new IllegalArgumentException("Installment has debt. Payment process must be PAY_DEBT or FORGIVE_DEBT.");
            }
        } else {
            if (process != PaymentProcessEnum.NO_DEBT) {
                throw new IllegalStateException("Installment has no debt. Payment process must be NO_DEBT.");
            }
        }

        // Create a new payment model
        PaymentModel paymentModel = new PaymentModel();

        paymentModel.setValue(paymentCreateRequestDTO.getValue());
        paymentModel.setTransactionCode(paymentCreateRequestDTO.getTransactionCode());
        paymentModel.setPaymentMethod(paymentMethod);
        paymentModel.setSale(sale);
        paymentModel.setInstallment(installment);
        paymentModel.setBank(bank);
        paymentModel.setCompany(company);
        paymentModel.setUser(user);
        paymentModel.setPaymentProcess(process);

        // Save and return
        return paymentMapper.toResponseDTO(paymentRepositoryAdapter.save(paymentModel));
    }

    @Override
    public void deleteById(Long id) {
        paymentRepositoryAdapter.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Payment not found with id: " + id));

        paymentRepositoryAdapter.deleteById(id);
    }
}
