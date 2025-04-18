package sales.sysconp.microservice.features.debt.domain.models;

import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class DebtModel {
    private Long id;
    private UUID uuid;
    private Double debtPercentage;
    private Double debtValue;
    private String debtDescription;
    private Long debtAppliedBy;
    private Long debtPayedOrForgivenBy;
    private LocalDateTime debtPayedAt;
    private LocalDateTime forgivenAt;
    private InstallmentModel installment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public DebtModel() {
    }

    public DebtModel(Long id, UUID uuid, Double debtPercentage, Double debtValue, String debtDescription, Long debtAppliedBy, Long debtPayedOrForgivenBy, LocalDateTime debtPayedAt, LocalDateTime forgivenAt, InstallmentModel installment, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
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

    public void setDebtPayedOrForgivenBy(Long debtPayedOrForgivenBy) {
        this.debtPayedOrForgivenBy = debtPayedOrForgivenBy;
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

    public void setForgivenAt(LocalDateTime forgivenAt) {
        this.forgivenAt = forgivenAt;
    }

    public InstallmentModel getInstallment() {
        return installment;
    }

    public void setInstallment(InstallmentModel installment) {
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
