package sales.sysconp.microservice.config.features.payment_method.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodResponseDTO;
import sales.sysconp.microservice.features.payment_method.application.services.PaymentMethodService;

import java.util.List;

@RestController
@RequestMapping("payment-method")
public class GetPaymentMethodByCompanyIdController {
    public final PaymentMethodService paymentMethodService;

    public GetPaymentMethodByCompanyIdController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping("company/{id}/all")
    public List<PaymentMethodResponseDTO> getPaymentMethodByCompanyId(
            @PathVariable("id") Long id
    ) {
        return paymentMethodService.getPaymentMethodByCompanyId(id);
    }
}
