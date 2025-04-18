package sales.sysconp.microservice.features.payment.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment.application.dto.PaymentCreateRequestDTO;
import sales.sysconp.microservice.features.payment.application.dto.PaymentResponseDTO;
import sales.sysconp.microservice.features.payment.application.services.PaymentService;

@RestController
@RequestMapping("payment")
public class CreatePaymentController {
    private final PaymentService paymentService;

    public CreatePaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("create")
    public PaymentResponseDTO createPayment(
            @RequestBody @Valid PaymentCreateRequestDTO paymentCreateRequestDTO
    ) {
        return paymentService.createPayment(paymentCreateRequestDTO);
    }
}