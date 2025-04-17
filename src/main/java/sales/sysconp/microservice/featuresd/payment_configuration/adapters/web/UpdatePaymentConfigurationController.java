package sales.sysconp.microservice.featuresd.payment_configuration.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationUpdateRequestDTO;
import sales.sysconp.microservice.features.payment_configuration.application.services.PaymentConfigurationService;

@RestController
@RequestMapping("payment-configuration")
public class UpdatePaymentConfigurationController {
    private final PaymentConfigurationService paymentConfigurationService;

    public UpdatePaymentConfigurationController(PaymentConfigurationService paymentConfigurationService) {
        this.paymentConfigurationService = paymentConfigurationService;
    }

    @PutMapping("update/{id}")
    public PaymentConfigurationResponseDTO updatePaymentConfiguration(
            @PathVariable("id") Long id,
            @RequestBody @Valid PaymentConfigurationUpdateRequestDTO paymentConfigurationUpdateRequestDTO
    ) {
        return paymentConfigurationService.updatePaymentConfiguration(id, paymentConfigurationUpdateRequestDTO);
    }
}