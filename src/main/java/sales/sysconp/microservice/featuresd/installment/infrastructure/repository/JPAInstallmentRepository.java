package sales.sysconp.microservice.featuresd.installment.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAInstallmentRepository extends JpaRepository<InstallmentEntity, Long> {
    List<InstallmentEntity> findBySaleId(Long saleId);

    List<InstallmentEntity> findBySaleUuid(UUID saleUuid);

    Optional<InstallmentEntity> findByUuid(UUID uuid);
}
