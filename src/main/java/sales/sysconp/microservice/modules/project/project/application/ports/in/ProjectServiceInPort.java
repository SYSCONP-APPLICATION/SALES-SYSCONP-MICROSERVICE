package sales.sysconp.microservice.modules.project.project.application.ports.in;

import sales.sysconp.microservice.modules.project.project.application.dto.ProjectCreateRequestDTO;
import sales.sysconp.microservice.modules.project.project.application.dto.ProjectResponseDTO;
import sales.sysconp.microservice.modules.project.project.application.dto.ProjectUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface ProjectServiceInPort {
    List<ProjectResponseDTO> getAllCompanyProjects(Long companyId);

    ProjectResponseDTO findProjectById(Long id);

    ProjectResponseDTO findProjectByUUID(UUID uuid);

    ProjectResponseDTO createProject(ProjectCreateRequestDTO projectCreateRequestDTO);

    ProjectResponseDTO updateProject(Long id, ProjectUpdateRequestDTO projectUpdateRequestDTO);

    void deleteProject(Long id);
}