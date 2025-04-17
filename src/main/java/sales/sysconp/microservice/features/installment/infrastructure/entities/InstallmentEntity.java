package sales.sysconp.microservice.features.installment.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import sales.sysconp.microservice.features.debt.infrastructure.entities.DebtEntity;
import sales.sysconp.microservice.features.installment.domain.enums.InstallmentTypeEnum;
import sales.sysconp.microservice.features.installment.domain.enums.MonthEnum;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;

@Entity
@Table(name = "installments")
@SQLDelete(sql = "UPDATE installments SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class InstallmentEntity {
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
    private Double amount;
    
    @Column(nullable = false)
    private LocalDateTime paymentDate;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private Integer index;

    @Column(nullable = true)
    private Double discount;

    @Column(nullable = true)
    private String additionalInfo;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MonthEnum month;

    @Column(nullable = true)
    private LocalDateTime paidAt;

    @Column(nullable = false)
    private InstallmentTypeEnum type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id", nullable = false, referencedColumnName = "id")
    private SaleEntity sale;

    @OneToMany(mappedBy = "installment", cascade = CascadeType.ALL)
    private List<PaymentEntity> payments;

    @OneToOne(mappedBy = "installment")
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

    public InstallmentEntity(Long id, UUID uuid, Double amount, LocalDateTime paymentDate, Double value, Integer index, Double discount, String additionalInfo, int year, MonthEnum month, LocalDateTime paidAt, InstallmentTypeEnum type, SaleEntity sale, List<PaymentEntity> payments, DebtEntity debt, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.value = value;
        this.index = index;
        this.discount = discount;
        this.additionalInfo = additionalInfo;
        this.year = year;
        this.month = month;
        this.paidAt = paidAt;
        this.type = type;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public MonthEnum getMonth() {
        return month;
    }

    public void setMonth(MonthEnum month) {
        this.month = month;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public InstallmentTypeEnum getType() {
        return type;
    }

    public void setType(InstallmentTypeEnum type) {
        this.type = type;
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