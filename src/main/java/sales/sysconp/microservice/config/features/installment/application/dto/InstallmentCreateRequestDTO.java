package sales.sysconp.microservice.config.features.installment.application.dto;

import jakarta.validation.constraints.NotNull;

public class InstallmentCreateRequestDTO {
    @NotNull(message = "Sale ID cannot be null")
    private Long saleId;

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
}