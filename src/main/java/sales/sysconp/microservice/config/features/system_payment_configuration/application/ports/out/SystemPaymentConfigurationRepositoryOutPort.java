package sales.sysconp.microservice.config.features.system_payment_configuration.application.ports.out;

import sales.sysconp.microservice.features.system_payment_configuration.domain.models.SystemPaymentConfigurationModel;

import java.util.Optional;
import java.util.UUID;

public interface SystemPaymentConfigurationRepositoryOutPort {
    Optional<SystemPaymentConfigurationModel>   findByCompanyId(Long companyId);

    Optional<SystemPaymentConfigurationModel>   findById(Long id);

    Optional<SystemPaymentConfigurationModel>   findByUUID(UUID uuid);

    SystemPaymentConfigurationModel             save(SystemPaymentConfigurationModel model);

    void                                        deleteById(Long id);
}