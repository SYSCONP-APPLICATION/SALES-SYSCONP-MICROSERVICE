package sales.sysconp.microservice.features.payment.domain.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import sales.sysconp.microservice.features.bank.infrastructure.entities.BankEntity;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;
import sales.sysconp.microservice.features.payment_method.infrastructure.entities.PaymentMethodEntity;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentModel {
    private Long id;
    private UUID uuid;
    private Double value;
    private PaymentMethodEntity paymentMethod;
    private SaleEntity sale;
    private InstallmentEntity installment;
    private BankEntity bank;
    private CompanyEntity company;
    private UserEntity user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PaymentModel() {
    }

    public PaymentModel(Long id, UUID uuid, Double value, PaymentMethodEntity paymentMethod, SaleEntity sale, InstallmentEntity installment, BankEntity bank, CompanyEntity company, UserEntity user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.value = value;
        this.paymentMethod = paymentMethod;
        this.sale = sale;
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

    public PaymentMethodEntity getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodEntity paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public SaleEntity getSale() {
        return sale;
    }

    public void setSale(SaleEntity sale) {
        this.sale = sale;
    }

    public InstallmentEntity getInstallment() {
        return installment;
    }

    public void setInstallment(InstallmentEntity installment) {
        this.installment = installment;
    }

    public BankEntity getBank() {
        return bank;
    }

    public void setBank(BankEntity bank) {
        this.bank = bank;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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