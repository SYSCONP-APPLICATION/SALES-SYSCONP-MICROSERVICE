package sales.sysconp.microservice.modules.project.collections.application.ports.out;
import sales.sysconp.microservice.modules.project.collections.domain.models.CollectionModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CollectionRepositoryOutPort {
    Optional<CollectionModel> findById(Long id);

    Optional<CollectionModel> findByUuid(UUID uuid);

    List<CollectionModel> findByProjectId(Long projectId);

    CollectionModel save(CollectionModel collectionModel);

    Optional<CollectionModel> findByIdAndProjectId(Long id, Long projectId);

    Optional<CollectionModel> findByNameAndProjectId(String name, Long projectId);

    Optional<CollectionModel> findByUuidAndProjectId(UUID uuid, Long projectId);

    void deleteById(Long id);
}