package sales.sysconp.microservice.modules.project.property.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyStatusEnum;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAPropertyRepository extends JpaRepository<PropertyEntity, Long> {
    Optional<PropertyEntity> findByUuid(UUID uuid);

    List<PropertyEntity> findByProjectId(Long projectId);

    List<PropertyEntity> findByCollectionId(Long collectionId);

    List<PropertyEntity> findByStreetId(Long streetId);

    List<PropertyEntity> findByPropertyCategoryId(Long propertyCategoryId);

    Optional<PropertyEntity> findByNameAndProjectId(String name, Long projectId);

    Optional<PropertyEntity> findByIdAndProjectId(Long id, Long projectId);

    Optional<PropertyEntity> findByUuidAndProjectId(UUID uuid, Long projectId);

    List<PropertyEntity> findByStatusAndProjectId(PropertyStatusEnum status, Long projectId);
}
