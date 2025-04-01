package sales.sysconp.microservice.features.debt.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;

@Entity
@Table(name = "debts")
public class DebtEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

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
    private Long debtPayedOrForgivedBy;

    @Column(nullable = true)
    private LocalDateTime debtPayedAt;

    @Column(nullable = true)
    private LocalDateTime forgivedAt;

    @OneToOne(mappedBy = "debt")
    private InstallmentEntity installment;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public DebtEntity() {
    }

    public DebtEntity(Long id, UUID uuid, Double debtPercentage, Double debtValue, String debtDescription, Long debtAppliedBy, Long debtPayedOrForgivedBy, LocalDateTime debtPayedAt, LocalDateTime forgivedAt, InstallmentEntity installment, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.debtPercentage = debtPercentage;
        this.debtValue = debtValue;
        this.debtDescription = debtDescription;
        this.debtAppliedBy = debtAppliedBy;
        this.debtPayedOrForgivedBy = debtPayedOrForgivedBy;
        this.debtPayedAt = debtPayedAt;
        this.forgivedAt = forgivedAt;
        this.installment = installment;
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

    public Long getDebtPayedOrForgivedBy() {
        return debtPayedOrForgivedBy;
    }

    public void setDebtPayedOrForgivedBy(Long debtPayedOrForgivedBy) {
        this.debtPayedOrForgivedBy = debtPayedOrForgivedBy;
    }

    public LocalDateTime getDebtPayedAt() {
        return debtPayedAt;
    }

    public void setDebtPayedAt(LocalDateTime debtPayedAt) {
        this.debtPayedAt = debtPayedAt;
    }

    public LocalDateTime getForgivedAt() {
        return forgivedAt;
    }

    public void setForgivedAt(LocalDateTime forgivedAt) {
        this.forgivedAt = forgivedAt;
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
}
