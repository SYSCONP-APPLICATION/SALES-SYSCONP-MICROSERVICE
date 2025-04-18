package sales.sysconp.microservice.features.debt.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;

@Entity
@Table(name = "debts")
@SQLDelete(sql = "UPDATE debts SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class DebtEntity {
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
    private Double debtPercentage;
    
    @Column(nullable = false)
    private Double debtValue;
    
    @Column(nullable = true)
    private String debtDescription;

    @Column(nullable = true)
    private Long debtAppliedBy;

    @Column(nullable = true)
    private Long debtPayedOrForgivenBy;

    @Column(nullable = true)
    private LocalDateTime debtPayedAt;

    @Column(nullable = true)
    private LocalDateTime forgivenAt;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "installment_id", referencedColumnName = "id")
    private InstallmentEntity installment;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column()
    private LocalDateTime deletedAt;

    public DebtEntity() {
    }

    public DebtEntity(Long id, UUID uuid, Double debtPercentage, Double debtValue, String debtDescription, Long debtAppliedBy, Long debtPayedOrForgivenBy, LocalDateTime debtPayedAt, LocalDateTime forgivenAt, InstallmentEntity installment, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.debtPercentage = debtPercentage;
        this.debtValue = debtValue;
        this.debtDescription = debtDescription;
        this.debtAppliedBy = debtAppliedBy;
        this.debtPayedOrForgivenBy = debtPayedOrForgivenBy;
        this.debtPayedAt = debtPayedAt;
        this.forgivenAt = forgivenAt;
        this.installment = installment;
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

    public Double getDebtPercentage() {
        return debtPercentage;
    }

    public void setDebtPercentage(Double debtPercentage) {
        this.debtPercentage = debtPercentage;
    }

    public Double getDebtValue() {
        return debtValue;
    }

    public void setDebtValue(Double debtValue) {
        this.debtValue = debtValue;
    }

    public String getDebtDescription() {
        return debtDescription;
    }

    public void setDebtDescription(String debtDescription) {
        this.debtDescription = debtDescription;
    }

    public Long getDebtAppliedBy() {
        return debtAppliedBy;
    }

    public void setDebtAppliedBy(Long debtAppliedBy) {
        this.debtAppliedBy = debtAppliedBy;
    }

    public Long getDebtPayedOrForgivenBy() {
        return debtPayedOrForgivenBy;
    }

    public void setDebtPayedOrForgivenBy(Long debtPayedOrForgivedBy) {
        this.debtPayedOrForgivenBy = debtPayedOrForgivedBy;
    }

    public LocalDateTime getDebtPayedAt() {
        return debtPayedAt;
    }

    public void setDebtPayedAt(LocalDateTime debtPayedAt) {
        this.debtPayedAt = debtPayedAt;
    }

    public LocalDateTime getForgivenAt() {
        return forgivenAt;
    }

    public void setForgivenAt(LocalDateTime forgivedAt) {
        this.forgivenAt = forgivedAt;
    }

    public InstallmentEntity getInstallment() {
        return installment;
    }

    public void setInstallment(InstallmentEntity installment) {
        this.installment = installment;
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
