package sales.sysconp.microservice.features.sale.application.dto;

import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.features.payment_configuration.infrastructure.entities.PaymentConfigurationEntity;
import sales.sysconp.microservice.features.sale.domain.enums.SaleStatus;
import sales.sysconp.microservice.features.sale.domain.enums.SaleType;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;
import sales.sysconp.microservice.modules.project.unity.infrastructure.entities.UnityEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class SaleResponseDTO {
    private Long id;
    private UUID uuid;
    private SaleStatus status;
    private ClientEntity client;
    private UserEntity user;
    private List<PaymentEntity> payments;
    private List<InstallmentEntity> installments;
    private PaymentConfigurationEntity paymentConfiguration;
    private Double initialValue;
    private Double globalValue;
    private Double discount;
    private Double installmentValue;
    private SaleType saleType;
    private String additionalInfo;
    private CompanyEntity company;
    private List<UnityEntity> unities;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SaleResponseDTO() { }

    public SaleResponseDTO(Long id, UUID uuid, SaleStatus status, ClientEntity client, UserEntity user, List<PaymentEntity> payments, List<InstallmentEntity> installments, PaymentConfigurationEntity paymentConfiguration, Double initialValue, Double globalValue, Double discount, Double installmentValue, SaleType saleType, String additionalInfo, CompanyEntity company, List<UnityEntity> unities, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.status = status;
        this.client = client;
        this.user = user;
        this.payments = payments;
        this.installments = installments;
        this.paymentConfiguration = paymentConfiguration;
        this.initialValue = initialValue;
        this.globalValue = globalValue;
        this.discount = discount;
        this.installmentValue = installmentValue;
        this.saleType = saleType;
        this.additionalInfo = additionalInfo;
        this.company = company;
        this.unities = unities;
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

    public Double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Double initialValue) {
        this.initialValue = initialValue;
    }

    public Double getGlobalValue() {
        return globalValue;
    }

    public void setGlobalValue(Double globalValue) {
        this.globalValue = globalValue;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(Double installmentValue) {
        this.installmentValue = installmentValue;
    }

    public SaleType getSaleType() {
        return saleType;
    }

    public void setSaleType(SaleType saleType) {
        this.saleType = saleType;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public List<UnityEntity> getUnities() {
        return unities;
    }

    public void setUnities(List<UnityEntity> unities) {
        this.unities = unities;
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