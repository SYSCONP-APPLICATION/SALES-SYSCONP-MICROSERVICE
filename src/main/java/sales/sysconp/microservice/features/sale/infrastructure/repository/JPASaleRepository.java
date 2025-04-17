package sales.sysconp.microservice.features.sale.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPASaleRepository extends JpaRepository<SaleEntity, Long> {
    List<SaleEntity> findAllByCompanyId(Long companyId);

    Optional<SaleEntity> findByUuid(UUID uuid);
}
