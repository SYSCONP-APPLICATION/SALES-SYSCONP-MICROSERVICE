package sales.sysconp.microservice.modules.project.collections.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.modules.project.collections.application.ports.out.CollectionRepositoryOutPort;
import sales.sysconp.microservice.modules.project.collections.domain.mappers.CollectionMapper;
import sales.sysconp.microservice.modules.project.collections.domain.models.CollectionModel;
import sales.sysconp.microservice.modules.project.collections.infrastructure.entities.CollectionEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CollectionRepositoryAdapter implements CollectionRepositoryOutPort {
    private final JPACollectionRepository jpaRepository;
    private final CollectionMapper mapper;

    public CollectionRepositoryAdapter(JPACollectionRepository jpaRepository, CollectionMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<CollectionModel> findById(Long id) {
        return this.jpaRepository.findById(id).map(this.mapper::toModel);
    }

    @Override
    public Optional<CollectionModel> findByUuid(UUID uuid) {
        return this.jpaRepository.findByUuid(uuid).map(this.mapper::toModel);
    }

    @Override
    public List<CollectionModel> findByProjectId(Long projectId) {
        return this.jpaRepository.findByProjectId(projectId).stream()
                .map(this.mapper::toModel)
                .toList();
    }

    @Override
    public CollectionModel save(CollectionModel collectionModel) {
        CollectionEntity entity = this.jpaRepository.save(this.mapper.toEntity(collectionModel));
        return this.mapper.toModel(entity);
    }

    @Override
    public Optional<CollectionModel> findByIdAndProjectId(Long id, Long projectId) {
        return this.jpaRepository.findByIdAndProjectId(id, projectId).map(this.mapper::toModel);
    }

    @Override
    public Optional<CollectionModel> findByNameAndProjectId(String name, Long projectId) {
        return this.jpaRepository.findByNameAndProjectId(name, projectId).map(this.mapper::toModel);
    }

    @Override
    public Optional<CollectionModel> findByUuidAndProjectId(UUID uuid, Long projectId) {
        return this.jpaRepository.findByUuidAndProjectId(uuid, projectId).map(this.mapper::toModel);
    }

    @Override
    public void deleteById(Long id) {
        this.jpaRepository.deleteById(id);
    }
}
