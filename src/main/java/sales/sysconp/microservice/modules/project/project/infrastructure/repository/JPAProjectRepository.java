package sales.sysconp.microservice.modules.project.project.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.modules.project.project.infrastructure.entities.ProjectEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAProjectRepository extends JpaRepository<ProjectEntity, Long> {
    Optional<ProjectEntity> findByUuid(UUID uuid);
    Optional<ProjectEntity> findByName(String name);
    List<ProjectEntity> findAllByCompanyId(Long companyId);
}
