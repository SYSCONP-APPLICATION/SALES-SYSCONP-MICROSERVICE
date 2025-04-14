package sales.sysconp.microservice.features.system_payment_configuration.application.dto;

public class SystemPaymentConfigurationUpdateRequestDTO {
    private Long dayOfMonth;

    private Long applyDebtAfter;

    private Boolean requireOnCreateSale;

    private Boolean requireForAllSales;

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
}