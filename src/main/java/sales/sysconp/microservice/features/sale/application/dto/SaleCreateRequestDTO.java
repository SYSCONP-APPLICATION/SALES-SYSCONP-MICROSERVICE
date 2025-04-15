package sales.sysconp.microservice.features.sale.application.dto;

import jakarta.validation.constraints.NotNull;
import sales.sysconp.microservice.features.sale.domain.enums.SaleStatus;

import java.util.List;

public class SaleCreateRequestDTO {
    @NotNull(message = "clientId cannot be null")
    private Long clientId;

    @NotNull(message = "userId cannot be null")
    private Long userId;

    @NotNull(message = "companyId cannot be null")
    private Long companyId;

    @NotNull(message = "unitiesArray cannot be null")
    private List<Long> unitiesArray;

    public Long getClientId() {
        return clientId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public List<Long> getUnitiesArray() {
        return unitiesArray;
    }
}