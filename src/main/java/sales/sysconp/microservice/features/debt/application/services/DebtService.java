package sales.sysconp.microservice.features.debt.application.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.client.infrastructure.repository.ClientRepositoryAdapter;
import sales.sysconp.microservice.features.debt.application.dto.DebtCreateRequestDTO;
import sales.sysconp.microservice.features.debt.application.dto.DebtResponseDTO;
import sales.sysconp.microservice.features.debt.application.ports.in.DebtServiceInPort;
import sales.sysconp.microservice.features.debt.domain.mappers.DebtMapper;
import sales.sysconp.microservice.features.debt.domain.models.DebtModel;
import sales.sysconp.microservice.features.debt.infrastructure.repository.DebtRepositoryAdapter;
import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;
import sales.sysconp.microservice.features.installment.infrastructure.repository.InstallmentRepositoryAdapter;
import sales.sysconp.microservice.features.payment_configuration.domain.models.PaymentConfigurationModel;
import sales.sysconp.microservice.features.payment_configuration.infrastructure.repository.PaymentConfigurationRepositoryAdapter;
import sales.sysconp.microservice.features.sale.infrastructure.repository.SaleRepositoryAdapter;
import sales.sysconp.microservice.modules.auth.user.infrastructure.repository.UserRepositoryAdapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class DebtService implements DebtServiceInPort {
    private final PaymentConfigurationRepositoryAdapter paymentConfigurationRepositoryAdapter;
    private final InstallmentRepositoryAdapter installmentRepositoryAdapter;
    private final SaleRepositoryAdapter saleRepositoryAdapter;
    private final DebtRepositoryAdapter debtRepositoryAdapter;
    private final ClientRepositoryAdapter clientRepositoryAdapter;
    private final UserRepositoryAdapter userRepositoryAdapter;
    private final DebtMapper mapper;

    public DebtService(SaleRepositoryAdapter saleRepositoryAdapter, UserRepositoryAdapter userRepositoryAdapter, InstallmentRepositoryAdapter installmentRepositoryAdapter, DebtRepositoryAdapter debtRepositoryAdapter, ClientRepositoryAdapter clientRepositoryAdapter, PaymentConfigurationRepositoryAdapter paymentConfigurationRepositoryAdapter, DebtMapper mapper) {
        this.paymentConfigurationRepositoryAdapter = paymentConfigurationRepositoryAdapter;
        this.clientRepositoryAdapter = clientRepositoryAdapter;
        this.installmentRepositoryAdapter = installmentRepositoryAdapter;
        this.saleRepositoryAdapter = saleRepositoryAdapter;
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.debtRepositoryAdapter = debtRepositoryAdapter;
        this.mapper = mapper;
    }

    @Override
    public DebtResponseDTO getDebtById(Long id) {
        return debtRepositoryAdapter.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Debt not found for id: " + id));
    }

    @Override
    public DebtResponseDTO getDebtByUUID(UUID uuid) {
        return debtRepositoryAdapter.findByUUID(uuid)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Debt not found for UUID: " + uuid));
    }

    @Override
    public List<DebtResponseDTO> getAllDebtsBySaleId(Long saleId) {
        this.saleRepositoryAdapter.findById(saleId)
                .orElseThrow(() -> new NoSuchElementException("Sale not found for id: " + saleId));

        List<DebtModel> debts = debtRepositoryAdapter.findAllBySaleId(saleId);

        if (debts.isEmpty()) {
            throw new NoSuchElementException("No debts found for sale id: " + saleId);
        }

        return debts.stream().map(mapper::toResponseDTO).toList();
    }

    @Override
    public List<DebtResponseDTO> getAllDebtsByClientId(Long clientId) {
        this.clientRepositoryAdapter.findById(clientId)
                .orElseThrow(() -> new NoSuchElementException("Client not found for id: " + clientId));

        List<DebtModel> debts = debtRepositoryAdapter.findAllByClientId(clientId);

        if (debts.isEmpty()) {
            throw new NoSuchElementException("No debts found for client id: " + clientId);
        }

        return debts.stream().map(mapper::toResponseDTO).toList();
    }

    @Transactional
    @Override
    public DebtResponseDTO createDebt(DebtCreateRequestDTO debtCreateRequestDTO) {
        PaymentConfigurationModel paymentConfigurationModel = this.paymentConfigurationRepositoryAdapter
                .findByInstallmentId(debtCreateRequestDTO.getInstallmentId())
                .orElseThrow(() -> new NoSuchElementException("Payment configuration not found for installment id: " + debtCreateRequestDTO.getInstallmentId()));

        InstallmentModel installmentModel = this.installmentRepositoryAdapter
                .findById(debtCreateRequestDTO.getInstallmentId())
                .orElseThrow(() -> new NoSuchElementException("Installment not found for installment id: " + debtCreateRequestDTO.getInstallmentId()));

        if (installmentModel.getDebt() != null) {
            throw new IllegalArgumentException("Cannot create debt for installment that was already paid.");
        }

        LocalDateTime now = LocalDateTime.now();

        if (now.getDayOfMonth() >= paymentConfigurationModel.getApplyDebtAfter()) {
            throw new IllegalArgumentException("Cannot create debt before the apply debt date.");
        }

        Double installmentValue = installmentModel.getValue();
        Double debtValue = paymentConfigurationModel.getDebtValue();
        Double debtPercentage = debtValue / installmentValue * 100;

        DebtModel debtModel = new DebtModel();
        debtModel.setDebtPercentage(debtPercentage);
        debtModel.setDebtValue(debtValue);
        debtModel.setDebtDescription(debtCreateRequestDTO.getDebtDescription());
        debtModel.setInstallment(installmentModel);

        return mapper.toResponseDTO(debtRepositoryAdapter.save(debtModel));
    }

    @Override
    public DebtResponseDTO forgiveDebt(Long id, Long userId) {
        this.userRepositoryAdapter.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found for id: " + userId));

        DebtModel debtModel = debtRepositoryAdapter.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Debt not found for id: " + id));

        if (debtModel.getDebtPayedAt() != null) {
            throw new IllegalArgumentException("Cannot forgive debt that was already paid.");
        }

        if (debtModel.getForgivenAt() != null) {
            throw new IllegalArgumentException("Cannot forgive debt that was already forgiven.");
        }

        debtModel.setDebtPayedOrForgivenBy(userId);
        debtModel.setForgivenAt(LocalDateTime.now());

        return mapper.toResponseDTO(debtRepositoryAdapter.save(debtModel));
    }

    @Override
    public DebtResponseDTO payDebt(Long id, Long userId) {
        this.userRepositoryAdapter.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found for id: " + userId));

        DebtModel debtModel = debtRepositoryAdapter.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Debt not found for id: " + id));

        if (debtModel.getDebtPayedAt() != null) {
            throw new IllegalArgumentException("Cannot pay debt that was already paid.");
        }

        if (debtModel.getForgivenAt() != null) {
            throw new IllegalArgumentException("Cannot pay debt that was already forgiven.");
        }

        debtModel.setDebtPayedOrForgivenBy(userId);
        debtModel.setDebtPayedAt(LocalDateTime.now());

        return mapper.toResponseDTO(debtRepositoryAdapter.save(debtModel));
    }

    @Override
    public void deleteDebtById(Long id) {
        debtRepositoryAdapter.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Debt not found for id: " + id));

        debtRepositoryAdapter.deleteById(id);
    }
}
