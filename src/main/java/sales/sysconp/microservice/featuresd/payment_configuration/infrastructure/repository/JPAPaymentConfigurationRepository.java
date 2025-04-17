package sales.sysconp.microservice.featuresd.payment_configuration.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.features.payment_configuration.infrastructure.entities.PaymentConfigurationEntity;

import java.util.Optional;
import java.util.UUID;

public interface JPAPaymentConfigurationRepository extends JpaRepository<PaymentConfigurationEntity, Long> {
    Optional<PaymentConfigurationEntity> findByUuid(UUID uuid);

    Optional<PaymentConfigurationEntity> findBySaleId(Long saleId);
}