package sales.sysconp.microservice.config.modules.project.project.application.services;

import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.repository.CompanyRepositoryAdapter;
import sales.sysconp.microservice.modules.project.project.application.dto.ProjectCreateRequestDTO;
import sales.sysconp.microservice.modules.project.project.application.dto.ProjectResponseDTO;
import sales.sysconp.microservice.modules.project.project.application.dto.ProjectUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.project.application.ports.in.ProjectServiceInPort;
import sales.sysconp.microservice.modules.project.project.domain.mappers.ProjectMapper;
import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;
import sales.sysconp.microservice.modules.project.project.infrastructure.repository.ProjectRepositoryAdapter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService implements ProjectServiceInPort {
    private final ProjectRepositoryAdapter projectRepositoryAdapter;
    private final CompanyRepositoryAdapter companyRepositoryAdapter;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepositoryAdapter projectRepositoryAdapter, ProjectMapper projectMapper, CompanyRepositoryAdapter companyRepositoryAdapter) {
        this.projectRepositoryAdapter = projectRepositoryAdapter;
        this.projectMapper = projectMapper;
        this.companyRepositoryAdapter = companyRepositoryAdapter;
    }

    @Override
    public List<ProjectResponseDTO> getAllCompanyProjects(Long companyId) {
        return projectRepositoryAdapter
                .findAll()
                .stream()
                .map(projectMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ProjectResponseDTO findProjectById(Long id) {
        return projectRepositoryAdapter
                .findById(id)
                .map(projectMapper::toResponseDTO)
                .orElseThrow();
    }

    @Override
    public ProjectResponseDTO findProjectByUUID(UUID uuid) {
        return projectRepositoryAdapter
                .findByUUID(uuid)
                .map(projectMapper::toResponseDTO)
                .orElseThrow();
    }

    @Override
    public ProjectResponseDTO createProject(ProjectCreateRequestDTO projectCreateRequestDTO) {
        Optional<ProjectModel> existingProjectById = projectRepositoryAdapter.findById(projectCreateRequestDTO.getId());
        Optional<ProjectModel> existingProjectByUUID = projectRepositoryAdapter.findByUUID(projectCreateRequestDTO.getUuid());

        if (existingProjectById.isPresent() || existingProjectByUUID.isPresent()) {
            throw new EntityExistsException("Ja existe um projeto com esse id ou uuid!");
        }

        CompanyModel companyModel = this.companyRepositoryAdapter
                .findById(projectCreateRequestDTO.getCompanyId())
                .orElseThrow(() -> new NoSuchElementException("Empresa nao encontrada!"));

        ProjectModel projectModel = new ProjectModel();

        projectModel.setId(projectCreateRequestDTO.getId());
        projectModel.setUuid(projectCreateRequestDTO.getUuid());
        projectModel.setName(projectCreateRequestDTO.getName());
        projectModel.setDescription(projectCreateRequestDTO.getDescription());
        projectModel.setStatus(projectCreateRequestDTO.getStatus());
        projectModel.setStartDate(projectCreateRequestDTO.getStartDate());
        projectModel.setEndDate(projectCreateRequestDTO.getEndDate());
        projectModel.setLocation(projectCreateRequestDTO.getLocation());
        projectModel.setCompany(companyModel);
        projectModel.setCreatedAt(projectCreateRequestDTO.getCreatedAt());
        projectModel.setUpdatedAt(projectCreateRequestDTO.getUpdatedAt());

        ProjectModel savedProjectModel = projectRepositoryAdapter.save(projectModel);
        return projectMapper.toResponseDTO(savedProjectModel);
    }

    @Override
    public ProjectResponseDTO updateProject(Long id, ProjectUpdateRequestDTO projectUpdateRequestDTO) {
        ProjectModel projectModel = projectRepositoryAdapter.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Projeto não encontrado!"));

        if (!projectModel.getName().equals(projectUpdateRequestDTO.getName())) {
            Optional<ProjectModel> existingProjectByName = projectRepositoryAdapter.findByName(projectUpdateRequestDTO.getName());

            if (existingProjectByName.isPresent()) {
                throw new EntityExistsException("Já existe um projeto com este nome!");
            }
        }

        projectModel.setName(projectUpdateRequestDTO.getName());
        projectModel.setDescription(projectUpdateRequestDTO.getDescription());
        projectModel.setStatus(projectUpdateRequestDTO.getStatus());
        projectModel.setStartDate(projectUpdateRequestDTO.getStartDate());
        projectModel.setEndDate(projectUpdateRequestDTO.getEndDate());
        projectModel.setUpdatedAt(projectUpdateRequestDTO.getUpdatedAt());

        return projectMapper.toResponseDTO(projectRepositoryAdapter.save(projectModel));
    }


    @Override
    public void deleteProject(Long id) {
        projectRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Projeto nao encontrado!"));

        projectRepositoryAdapter.deleteById(id);
    }
}
