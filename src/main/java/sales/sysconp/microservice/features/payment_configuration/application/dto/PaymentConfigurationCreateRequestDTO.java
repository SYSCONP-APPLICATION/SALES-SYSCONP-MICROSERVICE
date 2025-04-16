package sales.sysconp.microservice.features.payment_configuration.application.dto;

import jakarta.validation.constraints.NotNull;

public class PaymentConfigurationCreateRequestDTO {
    @NotNull(message = "Day of month is required")
    private Long dayOfMonth;
    
    @NotNull(message = "Sale is required")
    private Long saleId;
    
    @NotNull(message = "Apply debt after is required")
    private Long applyDebtAfter;

    public Long getDayOfMonth() {
        return dayOfMonth;
    }

    public Long getSaleId() {
        return saleId;
    }

    public Long getApplyDebtAfter() {
        return applyDebtAfter;
    }
}