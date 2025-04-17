package sales.sysconp.microservice.featuresd.payment_configuration.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.payment_configuration.application.services.PaymentConfigurationService;

@RestController
@RequestMapping("payment-configuration")
public class GetPaymentConfigurationBySaleIdController {
    private final PaymentConfigurationService paymentConfigurationService;

    public GetPaymentConfigurationBySaleIdController(PaymentConfigurationService paymentConfigurationService) {
        this.paymentConfigurationService = paymentConfigurationService;
    }

    @GetMapping("sale/{saleId}")
    public PaymentConfigurationResponseDTO getPaymentConfigurationBySaleId(
            @PathVariable("saleId") Long saleId
    ) {
        return paymentConfigurationService.getPaymentConfigurationBySaleId(saleId);
    }
}