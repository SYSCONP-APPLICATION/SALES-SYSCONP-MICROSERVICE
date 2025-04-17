package sales.sysconp.microservice.config.features.payment_configuration.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationCreateRequestDTO;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.payment_configuration.application.services.PaymentConfigurationService;

@RestController
@RequestMapping("payment-configuration")
public class CreatePaymentConfigurationController {
    private final PaymentConfigurationService paymentConfigurationService;
    
    public CreatePaymentConfigurationController(PaymentConfigurationService paymentConfigurationService) {
        this.paymentConfigurationService = paymentConfigurationService;
    }
    
    @PostMapping("create")
    public PaymentConfigurationResponseDTO createPaymentConfiguration(
            @RequestBody @Valid PaymentConfigurationCreateRequestDTO paymentConfigurationCreateRequestDTO
    ) {
        return paymentConfigurationService.createPaymentConfiguration(paymentConfigurationCreateRequestDTO);
    }
}