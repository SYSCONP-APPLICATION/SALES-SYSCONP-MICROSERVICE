package sales.sysconp.microservice.config.features.system_payment_configuration.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.system_payment_configuration.application.dto.SystemPaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.system_payment_configuration.application.services.SystemPaymentConfigurationService;

@RestController
@RequestMapping("system-payment-configuration")
public class GetSystemPaymentConfigurationByCompanyIdController {
    private final SystemPaymentConfigurationService systemPaymentConfigurationService;

    public GetSystemPaymentConfigurationByCompanyIdController(SystemPaymentConfigurationService systemPaymentConfigurationService) {
        this.systemPaymentConfigurationService = systemPaymentConfigurationService;
    }

    @GetMapping("company/{id}")
    public SystemPaymentConfigurationResponseDTO getSystemPaymentConfigurationByCompanyId(
        @PathVariable("id") Long id
    ) {
        return systemPaymentConfigurationService.getSystemPaymentConfigurationByCompanyId(id);
    }
}