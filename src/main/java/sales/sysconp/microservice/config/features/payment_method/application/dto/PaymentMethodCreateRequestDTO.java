package sales.sysconp.microservice.config.features.payment_method.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class PaymentMethodCreateRequestDTO {
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
    private String name;

    @NotNull(message = "Company must not be empty")
    @Positive(message = "Company must be a positive number")
    private Long companyId;

    public String getName() {
        return name;
    }

    public Long getCompanyId() {
        return companyId;
    }
}
