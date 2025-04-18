package sales.sysconp.microservice.features.debt.application.dto;

import jakarta.validation.constraints.NotNull;

public class DebtCreateRequestDTO {
    private String debtDescription;

    @NotNull(message = "Installment id must not be null")
    private Long installmentId;
//
//    @NotNull(message = "Installment id must not be null")
//    private Long saleId;

    public String getDebtDescription() {
        return debtDescription;
    }

    public Long getInstallmentId() {
        return installmentId;
    }

//    public Long getSaleId() {
//        return saleId;
//    }
}
