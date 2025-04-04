package sales.sysconp.microservice.modules.project.collections.application.ports.in;

import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionCreateRequestDTO;
import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionResponseDTO;
import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface CollectionServiceInPort {
    CollectionResponseDTO getCollectionById(Long id);

    CollectionResponseDTO getCollectionByUuid(UUID uuid);

    List<CollectionResponseDTO> getCollectionsByProjectId(Long projectId);

    CollectionResponseDTO createCollection(CollectionCreateRequestDTO collectionCreateRequestDTO);

    CollectionResponseDTO updateCollection(Long id, CollectionUpdateRequestDTO collectionUpdateRequestDTO);

    void deleteCollectionById(Long id);
}