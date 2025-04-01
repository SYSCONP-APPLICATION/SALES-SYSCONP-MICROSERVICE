package sales.sysconp.microservice.features.debt.domain.models;

import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class DebtModel {
    private Long id;
    private UUID uuid;
    private Double debtPercentage;
    private Double debtValue;
    private String debtDescription;
    private Long debtAppliedBy;
    private Long debtPayedOrForgivedBy;
    private LocalDateTime debtPayedAt;
    private LocalDateTime forgivedAt;
    private InstallmentEntity installment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DebtModel() {
    }

    public DebtModel(Long id, UUID uuid, Double debtPercentage, Double debtValue, String debtDescription, Long debtAppliedBy, Long debtPayedOrForgivedBy, LocalDateTime debtPayedAt, LocalDateTime forgivedAt, InstallmentEntity installment, LocalDateTime createdAt, LocalDateTime updatedAt) {
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
