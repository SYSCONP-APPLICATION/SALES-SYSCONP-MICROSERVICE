package sales.sysconp.microservice.config.modules.project.street.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.modules.project.street.infrastructure.entities.StreetEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAStreetRepository extends JpaRepository<StreetEntity, Long> {
    Optional<StreetEntity> findByUuid(UUID uuid);
    List<StreetEntity> findAllByProjectId(Long projectId);
    Optional<StreetEntity> findByIdAndProjectId(Long id, Long projectId);
    Optional<StreetEntity> findByUuidAndProjectId(UUID uuid, Long projectId);
    Optional<StreetEntity> findByNameAndProjectId(String name, Long projectId);
}
