package sales.sysconp.microservice.features.sale.domain.models;

import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.features.payment_configuration.infrastructure.entities.PaymentConfigurationEntity;
import sales.sysconp.microservice.features.sale.domain.enums.SaleStatus;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class SaleModel {
    private Long id;
    private UUID uuid;
    private SaleStatus status;
    private ClientEntity client;
    private UserEntity user;
    private List<PaymentEntity> payments;
    private List<InstallmentEntity> installments;
    private PaymentConfigurationEntity paymentConfiguration;
    private CompanyEntity company;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SaleModel() {
    }

    public SaleModel(Long id, UUID uuid, SaleStatus status, ClientEntity client, UserEntity user, List<PaymentEntity> payments, List<InstallmentEntity> installments, PaymentConfigurationEntity paymentConfiguration, CompanyEntity company, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.status = status;
        this.client = client;
        this.user = user;
        this.payments = payments;
        this.installments = installments;
        this.paymentConfiguration = paymentConfiguration;
        this.company = company;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<PaymentEntity> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentEntity> payments) {
        this.payments = payments;
    }

    public List<InstallmentEntity> getInstallments() {
        return installments;
    }

    public void setInstallments(List<InstallmentEntity> installments) {
        this.installments = installments;
    }

    public PaymentConfigurationEntity getPaymentConfiguration() {
        return paymentConfiguration;
    }

    public void setPaymentConfiguration(PaymentConfigurationEntity paymentConfiguration) {
        this.paymentConfiguration = paymentConfiguration;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}