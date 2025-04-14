package sales.sysconp.microservice.features.sale.application.dto;

import jakarta.validation.constraints.NotNull;
import sales.sysconp.microservice.features.sale.domain.enums.SaleStatus;

public class SaleUpdateRequestDTO {
    @NotNull(message = "status cannot be null")
    private SaleStatus status;

    public SaleStatus getStatus() {
        return status;
    }
}
