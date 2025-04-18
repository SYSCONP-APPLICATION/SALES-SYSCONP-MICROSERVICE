package sales.sysconp.microservice.features.payment_configuration.application.dto;

import jakarta.validation.constraints.NotNull;

public class PaymentConfigurationCreateRequestDTO {
    @NotNull(message = "Day of month is required")
    private Long dayOfMonth;

    @NotNull(message = "Apply debt after is required")
    private Long applyDebtAfter;

    @NotNull(message = "debt value is required")
    private Double debtValue;

    private Long saleId;

    public Long getDayOfMonth() {
        return dayOfMonth;
    }

    public Long getSaleId() {
        return saleId;
    }

    public Long getApplyDebtAfter() {
        return applyDebtAfter;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Double getDebtValue() {
        return debtValue;
    }
}