package sales.sysconp.microservice.featuresd.sale.application.dto;

import sales.sysconp.microservice.features.sale.domain.enums.SaleStatus;

public class SaleUpdateRequestDTO {
    private SaleStatus status;

    private String additionalInfo;

    public SaleStatus getStatus() {
        return status;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }
}