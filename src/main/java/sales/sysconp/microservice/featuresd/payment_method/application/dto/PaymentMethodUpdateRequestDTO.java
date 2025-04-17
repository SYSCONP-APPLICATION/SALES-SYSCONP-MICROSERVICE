package sales.sysconp.microservice.featuresd.payment_method.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PaymentMethodUpdateRequestDTO {
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
    private String name;

    public String getName() {
        return name;
    }
}