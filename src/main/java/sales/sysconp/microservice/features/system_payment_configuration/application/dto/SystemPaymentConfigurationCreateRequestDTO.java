package sales.sysconp.microservice.features.system_payment_configuration.application.dto;

import jakarta.validation.constraints.NotNull;

public class SystemPaymentConfigurationCreateRequestDTO {
    @NotNull(message = "Day of month is required")
    private Long dayOfMonth;

    @NotNull(message = "Apply debt after is required")
    private Long applyDebtAfter;

    @NotNull(message = "Require on create sale is required")
    private Boolean requireOnCreateSale;

    @NotNull(message = "Require for all sales is required")
    private Boolean requireForAllSales;

    @NotNull(message = "Company ID is required")
    private Long companyId;

    public Long getDayOfMonth() {
        return dayOfMonth;
    }

    public Long getApplyDebtAfter() {
        return applyDebtAfter;
    }

    public Boolean getRequireOnCreateSale() {
        return requireOnCreateSale;
    }

    public Boolean getRequireForAllSales() {
        return requireForAllSales;
    }

    public Long getCompanyId() {
        return companyId;
    }
}