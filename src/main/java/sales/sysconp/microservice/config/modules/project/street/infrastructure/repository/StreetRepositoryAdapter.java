package sales.sysconp.microservice.config.modules.project.street.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.modules.project.street.application.ports.out.StreetRepositoryOutPort;
import sales.sysconp.microservice.modules.project.street.domain.mappers.StreetMapper;
import sales.sysconp.microservice.modules.project.street.domain.models.StreetModel;
import sales.sysconp.microservice.modules.project.street.infrastructure.entities.StreetEntity;
import sales.sysconp.microservice.modules.project.street.infrastructure.repository.JPAStreetRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class StreetRepositoryAdapter implements StreetRepositoryOutPort {
    private final sales.sysconp.microservice.modules.project.street.infrastructure.repository.JPAStreetRepository jpaRepository;
    private final StreetMapper streetMapper;

    public StreetRepositoryAdapter(JPAStreetRepository jpaRepository, StreetMapper streetMapper) {
        this.jpaRepository = jpaRepository;
        this.streetMapper = streetMapper;
    }

    @Override
    public List<StreetModel> findAllByProjectId(Long projectId) {
        return jpaRepository.findAllByProjectId(projectId).stream()
                .map(streetMapper::toModel)
                .toList();
    }

    @Override
    public Optional<StreetModel> findById(Long id) {
        return jpaRepository.findById(id)
                .map(streetMapper::toModel);
    }

    @Override
    public Optional<StreetModel> findByIdAndProjectId(Long id, Long projectId) {
        return jpaRepository.findByIdAndProjectId(id, projectId).map(streetMapper::toModel);
    }

    @Override
    public Optional<StreetModel> findByUuidAndProjectId(UUID uuid, Long projectId) {
        return jpaRepository.findByUuidAndProjectId(uuid, projectId).map(streetMapper::toModel);
    }

    @Override
    public Optional<StreetModel> findByNameAndProjectId(String name, Long projectId) {
        return jpaRepository.findByNameAndProjectId(name, projectId).map(streetMapper::toModel);
    }

    @Override
    public Optional<StreetModel> findByUuid(UUID uuid) {
        return jpaRepository.findByUuid(uuid)
                .map(streetMapper::toModel);
    }

    @Override
    public StreetModel save(StreetModel streetModel) {
        StreetEntity savedEntity = jpaRepository.save(streetMapper.toEntity(streetModel));
        return streetMapper.toModel(savedEntity);
    }

    @Override
    public void delete(Long streetId) {
        jpaRepository.deleteById(streetId);
    }
}
