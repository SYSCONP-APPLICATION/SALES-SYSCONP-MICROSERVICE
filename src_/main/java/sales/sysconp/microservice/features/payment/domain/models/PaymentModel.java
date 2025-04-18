package sales.sysconp.microservice.features.payment.domain.models;

import sales.sysconp.microservice.features.bank.domain.models.BankModel;
import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;
import sales.sysconp.microservice.features.payment.domain.enums.PaymentProcessEnum;
import sales.sysconp.microservice.features.payment_method.domain.models.PaymentMethodModel;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentModel {
    private Long id;
    private UUID uuid;
    private Double value;
    private PaymentMethodModel paymentMethod;
    private SaleModel sale;
    private String transactionCode;
    private InstallmentModel installment;
    private BankModel bank;
    private CompanyModel company;
    private PaymentProcessEnum paymentProcess;
    private UserModel user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public PaymentModel() {
    }

    public PaymentModel(Long id, UUID uuid, Double value, PaymentMethodModel paymentMethod, SaleModel sale, String transactionCode, InstallmentModel installment, BankModel bank, CompanyModel company, PaymentProcessEnum paymentProcess, UserModel user, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.value = value;
        this.paymentMethod = paymentMethod;
        this.sale = sale;
        this.transactionCode = transactionCode;
        this.installment = installment;
        this.bank = bank;
        this.company = company;
        this.paymentProcess = paymentProcess;
        this.user = user;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public PaymentMethodModel getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodModel paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public SaleModel getSale() {
        return sale;
    }

    public void setSale(SaleModel sale) {
        this.sale = sale;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public InstallmentModel getInstallment() {
        return installment;
    }

    public void setInstallment(InstallmentModel installment) {
        this.installment = installment;
    }

    public BankModel getBank() {
        return bank;
    }

    public void setBank(BankModel bank) {
        this.bank = bank;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
        this.company = company;
    }

    public PaymentProcessEnum getPaymentProcess() {
        return paymentProcess;
    }

    public void setPaymentProcess(PaymentProcessEnum paymentProcess) {
        this.paymentProcess = paymentProcess;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
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