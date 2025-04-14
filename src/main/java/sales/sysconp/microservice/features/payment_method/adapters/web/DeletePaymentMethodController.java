package sales.sysconp.microservice.features.payment_method.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment_method.application.services.PaymentMethodService;

@RestController
@RequestMapping("payment-method")
public class DeletePaymentMethodController {
    public final PaymentMethodService paymentMethodService;

    public DeletePaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @DeleteMapping("delete/{id}")
    public void deletePaymentMethod(
            @PathVariable Long id
    ) {
        this.paymentMethodService.deletePaymentMethod(id);
    }
}