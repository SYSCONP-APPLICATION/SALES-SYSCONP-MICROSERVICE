package sales.sysconp.microservice.config.features.payment_configuration.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment_configuration.application.services.PaymentConfigurationService;

@RestController
@RequestMapping("payment-configuration")
public class DeletePaymentConfigurationByIdController {
    private final PaymentConfigurationService paymentConfigurationService;

    public DeletePaymentConfigurationByIdController(PaymentConfigurationService paymentConfigurationService) {
        this.paymentConfigurationService = paymentConfigurationService;
    }

    @DeleteMapping("delete/{id}")
    public void deletePaymentConfigurationById(
            @PathVariable("id") Long id
    ) {
        paymentConfigurationService.deleteById(id);
    }
}