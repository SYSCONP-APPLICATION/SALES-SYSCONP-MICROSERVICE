package sales.sysconp.microservice.features.payment_configuration.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sales.sysconp.microservice.features.payment_configuration.infrastructure.entities.PaymentConfigurationEntity;

import java.util.Optional;
import java.util.UUID;

public interface JPAPaymentConfigurationRepository extends JpaRepository<PaymentConfigurationEntity, Long> {
    Optional<PaymentConfigurationEntity> findByUuid(UUID uuid);

    Optional<PaymentConfigurationEntity> findBySaleId(Long saleId);

    @Query("""
    SELECT pc
    FROM PaymentConfigurationEntity pc
    JOIN pc.sale s
    JOIN s.installments i
    WHERE i.id = :installmentId
""")
    Optional<PaymentConfigurationEntity> findByInstallmentId(@Param("installmentId") Long installmentId);
}