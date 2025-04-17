package sales.sysconp.microservice.config.features.system_payment_configuration.application.dto;

public class SystemPaymentConfigurationUpdateRequestDTO {
    private Long dayOfMonth;

    private Long applyDebtAfter;

    private Boolean requireOnCreateSale;

    private Boolean requireForAllSales;

    private Long newMonthAfterDate;

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

    public Long getNewMonthAfterDate() {
        return newMonthAfterDate;
    }
}