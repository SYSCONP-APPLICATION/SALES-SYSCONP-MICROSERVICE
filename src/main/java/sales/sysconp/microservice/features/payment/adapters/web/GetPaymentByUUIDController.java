package sales.sysconp.microservice.features.payment.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment.application.dto.PaymentResponseDTO;
import sales.sysconp.microservice.features.payment.application.services.PaymentService;

import java.util.UUID;

@RestController
@RequestMapping("payment")
public class GetPaymentByUUIDController {
    private final PaymentService paymentService;

    public GetPaymentByUUIDController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("uuid/{uuid}")
    public PaymentResponseDTO getMPaymentByUUID(
            @PathVariable("uuid") UUID uuid
    ) {
        return paymentService.getPaymentByUUID(uuid);
    }
}