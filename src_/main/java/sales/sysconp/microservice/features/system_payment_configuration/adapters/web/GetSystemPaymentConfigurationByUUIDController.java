package sales.sysconp.microservice.features.system_payment_configuration.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.system_payment_configuration.application.dto.SystemPaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.system_payment_configuration.application.services.SystemPaymentConfigurationService;

import java.util.UUID;

@RestController
@RequestMapping("system-payment-configuration")
public class GetSystemPaymentConfigurationByUUIDController {
    private final SystemPaymentConfigurationService systemPaymentConfigurationService;

    public GetSystemPaymentConfigurationByUUIDController(SystemPaymentConfigurationService systemPaymentConfigurationService) {
        this.systemPaymentConfigurationService = systemPaymentConfigurationService;
    }

    @GetMapping("uuid/{uuid}")
    public SystemPaymentConfigurationResponseDTO getSystemPaymentConfigurationByUUID(
        @PathVariable("uuid") UUID uuid
    ) {
        return systemPaymentConfigurationService.getSystemPaymentConfigurationByUUID(uuid);
    }
}