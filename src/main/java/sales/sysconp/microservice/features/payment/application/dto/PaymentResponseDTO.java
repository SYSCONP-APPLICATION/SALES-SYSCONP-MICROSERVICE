package sales.sysconp.microservice.features.payment.application.dto;

import sales.sysconp.microservice.features.bank.domain.models.BankModel;
import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;
import sales.sysconp.microservice.features.payment.domain.enums.PaymentProcessEnum;
import sales.sysconp.microservice.features.payment_method.domain.models.PaymentMethodModel;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentResponseDTO {
    private Long id;
    private UUID uuid;
    private Double value;
    private PaymentProcessEnum paymentProcess;
    private PaymentMethodModel paymentMethod;
    private SaleModel sale;
    private String transactionCode;
    private InstallmentModel installment;
    private BankModel bank;
    private CompanyModel company;
    private UserModel user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PaymentResponseDTO() {
    }

    public PaymentResponseDTO(Long id, UUID uuid, Double value, PaymentProcessEnum paymentProcess, PaymentMethodModel paymentMethod, SaleModel sale, String transactionCode, InstallmentModel installment, BankModel bank, CompanyModel company, UserModel user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.value = value;
        this.paymentProcess = paymentProcess;
        this.paymentMethod = paymentMethod;
        this.sale = sale;
        this.transactionCode = transactionCode;
        this.installment = installment;
        this.bank = bank;
        this.company = company;
        this.user = user;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public PaymentProcessEnum getPaymentProcess() {
        return paymentProcess;
    }

    public void setPaymentProcess(PaymentProcessEnum paymentProcess) {
        this.paymentProcess = paymentProcess;
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
}
