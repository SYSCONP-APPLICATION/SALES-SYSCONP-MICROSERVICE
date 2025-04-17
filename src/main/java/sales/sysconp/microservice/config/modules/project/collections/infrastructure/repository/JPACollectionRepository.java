package sales.sysconp.microservice.config.modules.project.collections.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.modules.project.collections.infrastructure.entities.CollectionEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPACollectionRepository extends JpaRepository<CollectionEntity, Long> {
    Optional<CollectionEntity> findByUuid(UUID uuid);
    List<CollectionEntity> findByProjectId(Long projectId);
    Optional<CollectionEntity> findByNameAndProjectId(String name, Long projectId);
    Optional<CollectionEntity> findByUuidAndProjectId(UUID uuid, Long projectId);
    Optional<CollectionEntity> findByIdAndProjectId(Long id, Long projectId);
}
