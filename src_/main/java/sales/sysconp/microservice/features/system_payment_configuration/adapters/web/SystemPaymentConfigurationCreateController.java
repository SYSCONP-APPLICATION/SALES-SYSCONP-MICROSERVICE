package sales.sysconp.microservice.features.system_payment_configuration.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.system_payment_configuration.application.dto.SystemPaymentConfigurationCreateRequestDTO;
import sales.sysconp.microservice.features.system_payment_configuration.application.dto.SystemPaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.system_payment_configuration.application.services.SystemPaymentConfigurationService;

@RestController
@RequestMapping("system-payment-configuration")
public class SystemPaymentConfigurationCreateController {
    private final SystemPaymentConfigurationService systemPaymentConfigurationService;

    public SystemPaymentConfigurationCreateController(SystemPaymentConfigurationService systemPaymentConfigurationService) {
        this.systemPaymentConfigurationService = systemPaymentConfigurationService;
    }

    @PostMapping("create")
    public SystemPaymentConfigurationResponseDTO createSystemPaymentConfiguration(
            @RequestBody() @Valid SystemPaymentConfigurationCreateRequestDTO systemPaymentConfigurationResponseDTO
    ) {
        return systemPaymentConfigurationService.createSystemPaymentConfiguration(systemPaymentConfigurationResponseDTO);
    }
}