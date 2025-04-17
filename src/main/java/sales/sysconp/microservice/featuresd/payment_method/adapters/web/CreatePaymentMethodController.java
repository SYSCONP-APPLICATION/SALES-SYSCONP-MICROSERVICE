package sales.sysconp.microservice.featuresd.payment_method.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodCreateRequestDTO;
import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodResponseDTO;
import sales.sysconp.microservice.features.payment_method.application.services.PaymentMethodService;

@RestController
@RequestMapping("payment-method")
public class CreatePaymentMethodController {
    public final PaymentMethodService paymentMethodService;

    public CreatePaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @PostMapping("create")
    public PaymentMethodResponseDTO createPaymentMethod(
            @RequestBody @Valid PaymentMethodCreateRequestDTO paymentMethodCreateRequestDTO
    ) {
        return this.paymentMethodService.createPaymentMethod(paymentMethodCreateRequestDTO);
    }
}
