package sales.sysconp.microservice.modules.project.project.application.ports.out;

import sales.sysconp.microservice.modules.project.project.domain.enums.ProjectStatusEnum;
import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectRepositoryOutPort {
    List<ProjectModel> findAll();

    Optional<ProjectModel> findById(Long id);

    Optional<ProjectModel> findByUUID(UUID uuid);

    Optional<ProjectModel> findByName(String name);

    ProjectModel save(ProjectModel projectModel);

    List<ProjectModel> findAllByCompanyId(Long companyId);

    void deleteById(Long id);

    void updateProjectStatus(Long projectId, ProjectStatusEnum status);
}