package sales.sysconp.microservice.featuresd.payment_configuration.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.payment_configuration.application.services.PaymentConfigurationService;

import java.util.UUID;

@RestController
@RequestMapping("payment-configuration")
public class GetPaymentConfigurationByUUIDController {
    private final PaymentConfigurationService paymentConfigurationService;

    public GetPaymentConfigurationByUUIDController(PaymentConfigurationService paymentConfigurationService) {
        this.paymentConfigurationService = paymentConfigurationService;
    }

    @GetMapping("uuid/{uuid}")
    public PaymentConfigurationResponseDTO getPaymentConfigurationByUUID(
            @PathVariable("uuid") UUID uuid
    ) {
        return paymentConfigurationService.getPaymentConfigurationByUUID(uuid);
    }
}