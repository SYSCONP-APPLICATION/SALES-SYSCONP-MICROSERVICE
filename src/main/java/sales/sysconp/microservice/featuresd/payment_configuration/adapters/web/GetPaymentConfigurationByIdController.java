package sales.sysconp.microservice.featuresd.payment_configuration.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.payment_configuration.application.services.PaymentConfigurationService;

@RestController
@RequestMapping("payment-configuration")
public class GetPaymentConfigurationByIdController {
    private final PaymentConfigurationService paymentConfigurationService;

    public GetPaymentConfigurationByIdController(PaymentConfigurationService paymentConfigurationService) {
        this.paymentConfigurationService = paymentConfigurationService;
    }

    @GetMapping("get/{id}")
    public PaymentConfigurationResponseDTO getPaymentConfigurationById(
            @PathVariable("id") Long id
    ) {
        return paymentConfigurationService.getPaymentConfigurationById(id);
    }
}