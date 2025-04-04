package sales.sysconp.microservice.modules.project.property_category.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.modules.project.property_category.infrastructure.entities.PropertyCategoryEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAPropertyCategoryRepository extends JpaRepository<PropertyCategoryEntity, Long> {
    List<PropertyCategoryEntity> findAllByCompanyId(Long companyId);
    Optional<PropertyCategoryEntity> findByUuid(UUID uuid);
    Optional<PropertyCategoryEntity> findByNameAndCompanyId(String name, Long companyId);
    Optional<PropertyCategoryEntity> findByIdAndCompanyId(Long id, Long companyId);
    Optional<PropertyCategoryEntity> findByUuidAndCompanyId(UUID uuid, Long companyId);
}
