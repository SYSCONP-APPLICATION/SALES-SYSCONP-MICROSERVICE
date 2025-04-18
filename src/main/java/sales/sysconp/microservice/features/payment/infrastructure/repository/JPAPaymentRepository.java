package sales.sysconp.microservice.features.payment.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAPaymentRepository extends JpaRepository<PaymentEntity, Long> {
    Optional<PaymentEntity> findByUuid(UUID uuid);

    List<PaymentEntity> findAllBySaleId(Long saleId);

    List<PaymentEntity> findAllByCompanyId(Long companyId);
}
