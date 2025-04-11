package sales.sysconp.microservice.features.system_payment_configuration.application.dto;

import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class SystemPaymentConfigurationResponseDTO {
    private Long id;
    private UUID uuid;
    private Long dayOfMonth;
    private Long applyDebtAfter;
    private boolean requireOnCreateSale;
    private boolean requireForAllSales;
    private CompanyModel company;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SystemPaymentConfigurationResponseDTO() {
    }

    public SystemPaymentConfigurationResponseDTO(Long id, UUID uuid, Long dayOfMonth, Long applyDebtAfter, boolean requireOnCreateSale, boolean requireForAllSales, CompanyModel company, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.dayOfMonth = dayOfMonth;
        this.applyDebtAfter = applyDebtAfter;
        this.requireOnCreateSale = requireOnCreateSale;
        this.requireForAllSales = requireForAllSales;
        this.company = company;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApplyDebtAfter() {
        return applyDebtAfter;
    }

    public void setApplyDebtAfter(Long applyDebtAfter) {
        this.applyDebtAfter = applyDebtAfter;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
}
