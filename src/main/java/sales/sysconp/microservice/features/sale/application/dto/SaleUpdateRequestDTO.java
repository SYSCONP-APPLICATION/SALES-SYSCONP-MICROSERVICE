package sales.sysconp.microservice.features.sale.application.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.sale.domain.enums.SaleStatus;

@RestController
@RequestMapping("sale")
public class SaleUpdateRequestDTO {
    @NotNull(message = "status cannot be null")
    private SaleStatus status;

    public SaleStatus getStatus() {
        return status;
    }
}