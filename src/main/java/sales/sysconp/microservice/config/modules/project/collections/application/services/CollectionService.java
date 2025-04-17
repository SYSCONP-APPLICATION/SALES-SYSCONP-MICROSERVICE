package sales.sysconp.microservice.config.modules.project.collections.application.services;

import org.springframework.stereotype.Service;
import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionCreateRequestDTO;
import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionResponseDTO;
import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.collections.application.ports.in.CollectionServiceInPort;
import sales.sysconp.microservice.modules.project.collections.domain.mappers.CollectionMapper;
import sales.sysconp.microservice.modules.project.collections.domain.models.CollectionModel;
import sales.sysconp.microservice.modules.project.collections.infrastructure.repository.CollectionRepositoryAdapter;
import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;
import sales.sysconp.microservice.modules.project.project.infrastructure.repository.ProjectRepositoryAdapter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CollectionService implements CollectionServiceInPort {
    private final CollectionRepositoryAdapter collectionRepositoryAdapter;
    private final ProjectRepositoryAdapter projectRepositoryAdapter;
    private final CollectionMapper collectionMapper;

    public CollectionService(CollectionRepositoryAdapter collectionRepositoryAdapter, CollectionMapper collectionMapper, ProjectRepositoryAdapter projectRepositoryAdapter) {
        this.collectionRepositoryAdapter = collectionRepositoryAdapter;
        this.projectRepositoryAdapter = projectRepositoryAdapter;
        this.collectionMapper = collectionMapper;
    }

    @Override
    public CollectionResponseDTO getCollectionById(Long id) {
        return this.collectionRepositoryAdapter.findById(id)
                .map(this.collectionMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Collection not found with id: " + id));
    }

    @Override
    public CollectionResponseDTO getCollectionByUuid(UUID uuid) {
        return this.collectionRepositoryAdapter.findByUuid(uuid)
                .map(this.collectionMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Collection not found with uuid: " + uuid));
    }

    @Override
    public List<CollectionResponseDTO> getCollectionsByProjectId(Long projectId) {
        this.projectRepositoryAdapter.findById(projectId)
                .orElseThrow(() -> new NoSuchElementException("Project not found with id: " + projectId));

        return this.collectionRepositoryAdapter.findByProjectId(projectId)
                .stream()
                .map(this.collectionMapper::toResponseDTO)
                .toList();
    }

    @Override
    public CollectionResponseDTO createCollection(CollectionCreateRequestDTO collectionCreateRequestDTO) {
        ProjectModel projectModel = this.projectRepositoryAdapter.findById(collectionCreateRequestDTO.getProjectId())
                .orElseThrow(() -> new NoSuchElementException("Project not found with id: " + collectionCreateRequestDTO.getProjectId()));

        if (this.collectionRepositoryAdapter.findByNameAndProjectId(collectionCreateRequestDTO.getName(), collectionCreateRequestDTO.getProjectId()).isPresent()) {
            throw new IllegalArgumentException("Collection with name " + collectionCreateRequestDTO.getName() + " already exists in project " + collectionCreateRequestDTO.getProjectId());
        }

        CollectionModel collectionModel = new CollectionModel();

        collectionModel.setId(collectionCreateRequestDTO.getId());
        collectionModel.setUuid(collectionCreateRequestDTO.getUuid());
        collectionModel.setName(collectionCreateRequestDTO.getName());
        collectionModel.setDescription(collectionCreateRequestDTO.getDescription());
        collectionModel.setType(collectionCreateRequestDTO.getType());
        collectionModel.setProject(projectModel);
        collectionModel.setCreatedAt(collectionCreateRequestDTO.getCreatedAt());

        CollectionModel savedCollectionModel = this.collectionRepositoryAdapter.save(collectionModel);

        return this.collectionMapper.toResponseDTO(savedCollectionModel);
    }

    @Override
    public CollectionResponseDTO updateCollection(Long id, CollectionUpdateRequestDTO collectionUpdateRequestDTO) {
        CollectionModel collectionModelToUpdate = this.collectionRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Collection not found with id: " + id));

        ProjectModel projectModelToUpdate = this.projectRepositoryAdapter.findById(collectionUpdateRequestDTO.getProjectId())
                .orElseThrow(() -> new NoSuchElementException("Project not found with id: " + collectionUpdateRequestDTO.getProjectId()));

        if (this.collectionRepositoryAdapter.findByNameAndProjectId(collectionUpdateRequestDTO.getName(), collectionUpdateRequestDTO.getProjectId()).isPresent()) {
            throw new IllegalArgumentException("Collection with name " + collectionUpdateRequestDTO.getName() + " already exists in project " + collectionModelToUpdate.getProject().getId());
        }

        if (collectionUpdateRequestDTO.getName() != null) {
            collectionModelToUpdate.setName(collectionUpdateRequestDTO.getName());
        }

        if (collectionUpdateRequestDTO.getDescription() != null) {
            collectionModelToUpdate.setDescription(collectionUpdateRequestDTO.getDescription());
        }

        if (collectionUpdateRequestDTO.getType() != null) {
            collectionModelToUpdate.setType(collectionUpdateRequestDTO.getType());
        }

        if (collectionUpdateRequestDTO.getUpdatedAt() != null) {
            collectionModelToUpdate.setUpdatedAt(collectionUpdateRequestDTO.getUpdatedAt());
        }

        if (collectionUpdateRequestDTO.getProjectId() != null) {
            collectionModelToUpdate.setProject(projectModelToUpdate);
        }

        CollectionModel savedCollectionModel = this.collectionRepositoryAdapter.save(collectionModelToUpdate);

        return this.collectionMapper.toResponseDTO(savedCollectionModel);
    }

    @Override
    public void deleteCollectionById(Long id) {
        this.collectionRepositoryAdapter.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Collection not found with id: " + id));

        this.collectionRepositoryAdapter.deleteById(id);
    }
}
