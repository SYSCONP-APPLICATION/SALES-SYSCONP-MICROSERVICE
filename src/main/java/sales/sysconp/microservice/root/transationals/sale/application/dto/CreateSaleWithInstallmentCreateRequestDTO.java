package sales.sysconp.microservice.root.transationals.sale.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationCreateRequestDTO;
import sales.sysconp.microservice.features.sale.application.dto.SaleCreateRequestDTO;

public class CreateSaleWithInstallmentCreateRequestDTO {
    @Valid
    @NotNull(message = "saleType cannot be null")
    SaleCreateRequestDTO saleCreateRequestDTO;

    @Valid
    @NotNull(message = "paymentConfiguration cannot be null")
    PaymentConfigurationCreateRequestDTO paymentConfigurationCreateRequestDTO;

    public SaleCreateRequestDTO getSaleCreateRequestDTO() {
        return saleCreateRequestDTO;
    }

    public PaymentConfigurationCreateRequestDTO getPaymentConfigurationCreateRequestDTO() {
        return paymentConfigurationCreateRequestDTO;
    }
}