package sales.sysconp.microservice.featuresd.sale.application.dto;

import jakarta.validation.constraints.NotNull;
import sales.sysconp.microservice.features.sale.domain.enums.SaleType;

import java.util.List;

public class SaleCreateRequestDTO {
    @NotNull(message = "clientId cannot be null")
    private Long clientId;

    @NotNull(message = "userId cannot be null")
    private Long userId;

    @NotNull(message = "discount cannot be null")
    private Double discount;

    @NotNull(message = "companyId cannot be null")
    private Long companyId;

    @NotNull(message = "unitiesArray cannot be null")
    private List<Long> unitiesArray;

    @NotNull(message = "initialValue cannot be null")
    private Double initialValue;

    @NotNull(message = "globalValue cannot be null")
    private Double globalValue;

    @NotNull(message = "installmentValue cannot be null")
    private Double installmentValue;

    @NotNull(message = "saleType cannot be null")
    private SaleType saleType;

    @NotNull(message = "additionalInfo cannot be null")
    private String additionalInfo;

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

    public Double getInitialValue() {
        return initialValue;
    }

    public Double getGlobalValue() {
        return globalValue;
    }

    public Double getDiscount() { return discount; }

    public Double getInstallmentValue() {
        return installmentValue;
    }

    public SaleType getSaleType() {
        return saleType;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }
}