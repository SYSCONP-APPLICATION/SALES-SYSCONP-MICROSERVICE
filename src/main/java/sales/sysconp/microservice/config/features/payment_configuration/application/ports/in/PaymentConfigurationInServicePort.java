package sales.sysconp.microservice.config.features.payment_configuration.application.ports.in;

import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationCreateRequestDTO;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationUpdateRequestDTO;

import java.util.UUID;

public interface PaymentConfigurationInServicePort {
    PaymentConfigurationResponseDTO getPaymentConfigurationById(Long id);

    PaymentConfigurationResponseDTO getPaymentConfigurationByUUID(UUID uuid);

    PaymentConfigurationResponseDTO getPaymentConfigurationBySaleId(Long companyId);

    PaymentConfigurationResponseDTO createPaymentConfiguration(PaymentConfigurationCreateRequestDTO request);

    PaymentConfigurationResponseDTO updatePaymentConfiguration(Long id, PaymentConfigurationUpdateRequestDTO request);

    void deleteById(Long id);
}