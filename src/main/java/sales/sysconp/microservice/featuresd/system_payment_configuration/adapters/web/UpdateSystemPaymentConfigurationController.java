package sales.sysconp.microservice.featuresd.system_payment_configuration.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.system_payment_configuration.application.dto.SystemPaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.system_payment_configuration.application.dto.SystemPaymentConfigurationUpdateRequestDTO;
import sales.sysconp.microservice.features.system_payment_configuration.application.services.SystemPaymentConfigurationService;


@RestController
@RequestMapping("system-payment-configuration")
public class UpdateSystemPaymentConfigurationController {
    private final SystemPaymentConfigurationService systemPaymentConfigurationService;

    public UpdateSystemPaymentConfigurationController(SystemPaymentConfigurationService systemPaymentConfigurationService) {
        this.systemPaymentConfigurationService = systemPaymentConfigurationService;
    }

    @PutMapping("update/{id}")
    public SystemPaymentConfigurationResponseDTO updateSystemPaymentConfiguration(
        @PathVariable("id") Long id,
        @RequestBody() @Valid SystemPaymentConfigurationUpdateRequestDTO systemPaymentConfigurationResponseDTO
    ) {
        return systemPaymentConfigurationService.updateSystemPaymentConfiguration(id, systemPaymentConfigurationResponseDTO);
    }
}