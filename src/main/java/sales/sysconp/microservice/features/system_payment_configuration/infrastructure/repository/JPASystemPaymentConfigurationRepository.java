package sales.sysconp.microservice.features.system_payment_configuration.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.features.system_payment_configuration.infrastructure.entities.SystemPaymentConfigurationEntity;

import java.util.Optional;
import java.util.UUID;

public interface JPASystemPaymentConfigurationRepository extends JpaRepository<SystemPaymentConfigurationEntity, Long> {
    Optional<SystemPaymentConfigurationEntity> findByCompanyId(Long companyId);

    Optional<SystemPaymentConfigurationEntity> findByUuid(UUID uuid);
}
