package sales.sysconp.microservice.features.payment_configuration.application.dto;

public class PaymentConfigurationUpdateRequestDTO {
    private Long dayOfMonth;

    private Long applyDebtAfter;

    public Long getDayOfMonth() {
        return dayOfMonth;
    }

    public Long getApplyDebtAfter() {
        return applyDebtAfter;
    }
}