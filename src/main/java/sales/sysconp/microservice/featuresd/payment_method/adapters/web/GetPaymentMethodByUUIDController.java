package sales.sysconp.microservice.featuresd.payment_method.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodResponseDTO;
import sales.sysconp.microservice.features.payment_method.application.services.PaymentMethodService;

import java.util.UUID;

@RestController
@RequestMapping("payment-method")
public class GetPaymentMethodByUUIDController {
    public final PaymentMethodService paymentMethodService;

    public GetPaymentMethodByUUIDController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping("uuid/{uuid}")
    public PaymentMethodResponseDTO getPaymentMethodByUUID(
            @PathVariable("uuid") UUID uuid
    ) {
        return paymentMethodService.getPaymentMethodByUUID(uuid);
    }
}