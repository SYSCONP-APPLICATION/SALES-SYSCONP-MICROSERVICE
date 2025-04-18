package sales.sysconp.microservice.features.payment.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import sales.sysconp.microservice.features.bank.infrastructure.entities.BankEntity;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;
import sales.sysconp.microservice.features.payment.domain.enums.PaymentProcessEnum;
import sales.sysconp.microservice.features.payment_method.infrastructure.entities.PaymentMethodEntity;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;

@Entity
@Table(name = "payments")
@SQLDelete(sql = "UPDATE payments SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @PrePersist
    public void generateUUID () {
        this.uuid = UUID.randomUUID();
    }
    
    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private PaymentProcessEnum paymentProcess;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethodEntity paymentMethod;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false, referencedColumnName = "id")
    private SaleEntity sale;

    @ManyToOne
    @JoinColumn(name = "installment_id", nullable = false, referencedColumnName = "id")
    private InstallmentEntity installment;

    @Column(nullable = false)
    private String transactionCode;

    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    private BankEntity bank;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column()
    private LocalDateTime deletedAt;

    public PaymentEntity() {
    }

    public PaymentEntity(Long id, UUID uuid, Double value, PaymentProcessEnum paymentProcess, PaymentMethodEntity paymentMethod, SaleEntity sale, InstallmentEntity installment, String transactionCode, BankEntity bank, CompanyEntity company, UserEntity user, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.value = value;
        this.paymentProcess = paymentProcess;
        this.paymentMethod = paymentMethod;
        this.sale = sale;
        this.installment = installment;
        this.transactionCode = transactionCode;
        this.bank = bank;
        this.company = company;
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

    public PaymentProcessEnum getPaymentProcess() {
        return paymentProcess;
    }

    public void setPaymentProcess(PaymentProcessEnum paymentProcess) {
        this.paymentProcess = paymentProcess;
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

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
