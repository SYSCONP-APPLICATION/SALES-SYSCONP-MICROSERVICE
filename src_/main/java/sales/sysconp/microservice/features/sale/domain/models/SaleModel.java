package sales.sysconp.microservice.features.sale.domain.models;

import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;
import sales.sysconp.microservice.features.payment.domain.models.PaymentModel;
import sales.sysconp.microservice.features.payment_configuration.domain.models.PaymentConfigurationModel;
import sales.sysconp.microservice.features.sale.domain.enums.SaleStatus;
import sales.sysconp.microservice.features.sale.domain.enums.SaleType;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class SaleModel {
    private Long id;
    private UUID uuid;
    private SaleStatus status;
    private ClientModel client;
    private UserModel user;
    private List<UnityModel> unities;
    private List<PaymentModel> payments;
    private List<InstallmentModel> installments;
    private PaymentConfigurationModel paymentConfiguration;
    private Double initialValue;
    private Double globalValue;
    private Double discount;
    private Double installmentValue;
    private SaleType saleType;
    private String additionalInfo;
    private CompanyModel company;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public SaleModel() {
    }

    public SaleModel(Long id, UUID uuid, SaleStatus status, ClientModel client, UserModel user, List<UnityModel> unities, List<PaymentModel> payments, List<InstallmentModel> installments, PaymentConfigurationModel paymentConfiguration, Double initialValue, Double globalValue, Double discount, Double installmentValue, SaleType saleType, String additionalInfo, CompanyModel company, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.status = status;
        this.client = client;
        this.user = user;
        this.unities = unities;
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
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
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

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<UnityModel> getUnities() {
        return unities;
    }

    public void setUnities(List<UnityModel> unities) {
        this.unities = unities;
    }

    public List<PaymentModel> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentModel> payments) {
        this.payments = payments;
    }

    public List<InstallmentModel> getInstallments() {
        return installments;
    }

    public void setInstallments(List<InstallmentModel> installments) {
        this.installments = installments;
    }

    public PaymentConfigurationModel getPaymentConfiguration() {
        return paymentConfiguration;
    }

    public void setPaymentConfiguration(PaymentConfigurationModel paymentConfiguration) {
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

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}