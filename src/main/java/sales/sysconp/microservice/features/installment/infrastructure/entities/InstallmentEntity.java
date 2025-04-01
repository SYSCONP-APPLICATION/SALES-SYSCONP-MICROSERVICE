package sales.sysconp.microservice.features.installment.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.debt.infrastructure.entities.DebtEntity;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;

@Entity
@Table(name = "installments")
public class InstallmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    public void generateUUID () {
        this.uuid = UUID.randomUUID();
    }
    
    @Column(nullable = false)
    private Double amount;
    
    @Column(nullable = false)
    private LocalDateTime paymentDate;

    @Column(nullable = false)
    private LocalDateTime paidAt;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false, referencedColumnName = "id")
    private SaleEntity sale;

    @OneToMany(mappedBy = "installment", cascade = CascadeType.ALL)
    private List<PaymentEntity> payments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debt_id", referencedColumnName = "id")
    private DebtEntity debt;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column()
    private LocalDateTime deletedAt;

    public InstallmentEntity() {
    }

    public InstallmentEntity(Long id, UUID uuid, Double amount, LocalDateTime paymentDate, LocalDateTime paidAt, SaleEntity sale, List<PaymentEntity> payments, DebtEntity debt, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paidAt = paidAt;
        this.sale = sale;
        this.payments = payments;
        this.debt = debt;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public SaleEntity getSale() {
        return sale;
    }

    public void setSale(SaleEntity sale) {
        this.sale = sale;
    }

    public List<PaymentEntity> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentEntity> payments) {
        this.payments = payments;
    }

    public DebtEntity getDebt() {
        return debt;
    }

    public void setDebt(DebtEntity debt) {
        this.debt = debt;
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