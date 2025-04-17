package sales.sysconp.microservice.config.modules.auth.company.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;

import java.util.Optional;
import java.util.UUID;

public interface JPACompanyRepository extends JpaRepository<CompanyEntity, Long> {
    Optional<CompanyEntity> findByUuid(UUID uuid);
    Optional<CompanyEntity> findByBrandName(String brandName);
    Optional<CompanyEntity> findByCommercialName(String commercialName);
}
