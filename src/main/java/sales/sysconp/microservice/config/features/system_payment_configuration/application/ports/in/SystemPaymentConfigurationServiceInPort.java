package sales.sysconp.microservice.config.features.system_payment_configuration.application.ports.in;

import sales.sysconp.microservice.features.system_payment_configuration.application.dto.SystemPaymentConfigurationCreateRequestDTO;
import sales.sysconp.microservice.features.system_payment_configuration.application.dto.SystemPaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.system_payment_configuration.application.dto.SystemPaymentConfigurationUpdateRequestDTO;

import java.util.UUID;

public interface SystemPaymentConfigurationServiceInPort {
    SystemPaymentConfigurationResponseDTO   getSystemPaymentConfigurationByCompanyId(Long companyId);

    SystemPaymentConfigurationResponseDTO   getSystemPaymentConfigurationById(Long id);

    SystemPaymentConfigurationResponseDTO   getSystemPaymentConfigurationByUUID(UUID uuid);

    SystemPaymentConfigurationResponseDTO   createSystemPaymentConfiguration(SystemPaymentConfigurationCreateRequestDTO systemPaymentConfigurationResponseDTO);

    SystemPaymentConfigurationResponseDTO   updateSystemPaymentConfiguration(Long id, SystemPaymentConfigurationUpdateRequestDTO systemPaymentConfigurationResponseDTO);

    void                                    deleteSystemPaymentConfigurationById(Long id);
}