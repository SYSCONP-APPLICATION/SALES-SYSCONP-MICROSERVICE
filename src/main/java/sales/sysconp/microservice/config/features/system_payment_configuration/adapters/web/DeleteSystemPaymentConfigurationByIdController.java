package sales.sysconp.microservice.config.features.system_payment_configuration.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.system_payment_configuration.application.services.SystemPaymentConfigurationService;

@RestController
@RequestMapping("system-payment-configuration")
public class DeleteSystemPaymentConfigurationByIdController {
    private final SystemPaymentConfigurationService systemPaymentConfigurationService;

    public DeleteSystemPaymentConfigurationByIdController(SystemPaymentConfigurationService systemPaymentConfigurationService) {
        this.systemPaymentConfigurationService = systemPaymentConfigurationService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteSystemPaymentConfigurationById(
        @PathVariable("id") Long id
    ) {
        systemPaymentConfigurationService.deleteSystemPaymentConfigurationById(id);
    }
}