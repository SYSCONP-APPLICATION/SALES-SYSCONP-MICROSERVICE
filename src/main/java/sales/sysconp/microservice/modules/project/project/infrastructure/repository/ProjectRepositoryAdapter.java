package sales.sysconp.microservice.modules.project.project.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.modules.project.project.application.ports.out.ProjectRepositoryOutPort;
import sales.sysconp.microservice.modules.project.project.domain.mappers.ProjectMapper;
import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProjectRepositoryAdapter implements ProjectRepositoryOutPort {

    private final JPAProjectRepository jpaRepository;
    private final ProjectMapper projectMapper;

    public ProjectRepositoryAdapter(JPAProjectRepository jpaRepository, ProjectMapper projectMapper) {
        this.jpaRepository = jpaRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public List<ProjectModel> findAll() {
        return jpaRepository.findAll().stream().map(projectMapper::toModel).toList();
    }

    @Override
    public Optional<ProjectModel> findById(Long id) {
        return jpaRepository.findById(id).map(projectMapper::toModel);
    }

    @Override
    public Optional<ProjectModel> findByUUID(UUID uuid) {
        return jpaRepository.findByUuid(uuid).map(projectMapper::toModel);
    }

    @Override
    public Optional<ProjectModel> findByName(String name) {
        return jpaRepository.findByName(name).map(projectMapper::toModel);
    }

    @Override
    public ProjectModel save(ProjectModel projectModel) {
        return projectMapper.toModel(jpaRepository.save(projectMapper.toEntity(projectModel)));
    }

    @Override
    public List<ProjectModel> findAllByCompanyId(Long companyId) {
        return jpaRepository.findAllByCompanyId(companyId).stream().map(projectMapper::toModel).toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
