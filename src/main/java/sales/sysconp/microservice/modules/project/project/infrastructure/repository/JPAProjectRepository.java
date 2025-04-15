package sales.sysconp.microservice.modules.project.project.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sales.sysconp.microservice.modules.project.project.domain.enums.ProjectStatusEnum;
import sales.sysconp.microservice.modules.project.project.infrastructure.entities.ProjectEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAProjectRepository extends JpaRepository<ProjectEntity, Long> {
    Optional<ProjectEntity> findByUuid(UUID uuid);

    Optional<ProjectEntity> findByName(String name);

    List<ProjectEntity> findAllByCompanyId(Long companyId);

    @Modifying
    @Query("UPDATE ProjectEntity p SET p.status = :status WHERE p.id = :projectId")
    void updateProjectStatus(@Param("projectId") Long projectId, @Param("status") ProjectStatusEnum status);
}
