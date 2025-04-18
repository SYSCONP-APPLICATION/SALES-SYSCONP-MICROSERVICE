package sales.sysconp.microservice.features.payment_method.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodResponseDTO;
import sales.sysconp.microservice.features.payment_method.application.services.PaymentMethodService;

@RestController
@RequestMapping("payment-method")
public class GetPaymentMethodByIdController {
    public final PaymentMethodService paymentMethodService;

    public GetPaymentMethodByIdController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping("get/{id}")
    public PaymentMethodResponseDTO getPaymentMethodById(
            @PathVariable("id") Long id
    ) {
        return paymentMethodService.getPaymentMethodById(id);
    }
}
