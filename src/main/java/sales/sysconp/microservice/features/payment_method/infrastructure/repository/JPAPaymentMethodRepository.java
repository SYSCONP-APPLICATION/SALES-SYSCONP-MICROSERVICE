package sales.sysconp.microservice.features.payment_method.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.features.payment_method.infrastructure.entities.PaymentMethodEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAPaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Long> {
    Optional<PaymentMethodEntity> findByUuid(UUID uuid);

    Optional<PaymentMethodEntity> findByName(String name);

    Optional<PaymentMethodEntity> findByNameAndCompanyId(String name, Long companyId);

    List<PaymentMethodEntity> findByCompanyId(Long companyId);
}
