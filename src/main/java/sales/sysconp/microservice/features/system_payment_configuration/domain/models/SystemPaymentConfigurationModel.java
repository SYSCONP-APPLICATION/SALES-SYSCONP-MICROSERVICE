package sales.sysconp.microservice.features.system_payment_configuration.domain.models;

import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class SystemPaymentConfigurationModel {
    private Long id;
    private UUID uuid;
    private Long dayOfMonth;
    private boolean requireOnCreateSale;
    private boolean requireForAllSales;
    private CompanyModel company;
    private Long applyDebtAfter;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public SystemPaymentConfigurationModel() {
    }

    public SystemPaymentConfigurationModel(Long id, UUID uuid, Long dayOfMonth, boolean requireOnCreateSale, boolean requireForAllSales, Long applyDebtAfter, CompanyModel company, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.dayOfMonth = dayOfMonth;
        this.applyDebtAfter = applyDebtAfter;
        this.requireOnCreateSale = requireOnCreateSale;
        this.requireForAllSales = requireForAllSales;
        this.company = company;
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

    public Long getApplyDebtAfter() {
        return applyDebtAfter;
    }

    public void setApplyDebtAfter(Long applyDebtAfter) {
        this.applyDebtAfter = applyDebtAfter;
    }

    public Long getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Long dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public boolean isRequireOnCreateSale() {
        return requireOnCreateSale;
    }

    public void setRequireOnCreateSale(boolean requireOnCreateSale) {
        this.requireOnCreateSale = requireOnCreateSale;
    }

    public boolean isRequireForAllSales() {
        return requireForAllSales;
    }

    public void setRequireForAllSales(boolean requireForAllSales) {
        this.requireForAllSales = requireForAllSales;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
        this.company = company;
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