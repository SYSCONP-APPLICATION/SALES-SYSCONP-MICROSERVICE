package sales.sysconp.microservice.root.transactionals.payment.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import sales.sysconp.microservice.features.payment.application.dto.PaymentCreateRequestDTO;

import java.util.List;

public class CreatePaymentsRequestDTO {
    @Valid
    @NotNull(message = "paymentCreateRequestDTO cannot be null")
    private List<PaymentCreateRequestDTO> paymentCreateRequestDTO;

    public List<PaymentCreateRequestDTO> getPaymentCreateRequestDTO() {
        return paymentCreateRequestDTO;
    }
}
