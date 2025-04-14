package sales.sysconp.microservice.modules.project.property.application.services;

import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.modules.project.collections.domain.models.CollectionModel;
import sales.sysconp.microservice.modules.project.collections.infrastructure.repository.CollectionRepositoryAdapter;
import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;
import sales.sysconp.microservice.modules.project.project.infrastructure.repository.ProjectRepositoryAdapter;
import sales.sysconp.microservice.modules.project.property.application.dto.PropertyCreateRequestDTO;
import sales.sysconp.microservice.modules.project.property.application.dto.PropertyResponseDTO;
import sales.sysconp.microservice.modules.project.property.application.dto.PropertyUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.property.application.ports.in.PropertyServiceInPort;
import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyStatusEnum;
import sales.sysconp.microservice.modules.project.property.domain.mappers.PropertyMapper;
import sales.sysconp.microservice.modules.project.property.domain.models.PropertyModel;
import sales.sysconp.microservice.modules.project.property.infrastructure.repository.PropertyRepositoryAdapter;
import sales.sysconp.microservice.modules.project.property_category.domain.models.PropertyCategoryModel;
import sales.sysconp.microservice.modules.project.property_category.infrastructure.repository.PropertyCategoryRepositoryAdapter;
import sales.sysconp.microservice.modules.project.street.domain.models.StreetModel;
import sales.sysconp.microservice.modules.project.street.infrastructure.repository.StreetRepositoryAdapter;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PropertyService implements PropertyServiceInPort {
    private final PropertyRepositoryAdapter propertyRepositoryAdapter;
    private final ProjectRepositoryAdapter projectRepositoryAdapter;
    private final CollectionRepositoryAdapter collectionRepositoryAdapter;
    private final StreetRepositoryAdapter streetRepositoryAdapter;
    private final PropertyCategoryRepositoryAdapter propertyCategoryRepositoryAdapter;
    private final PropertyMapper propertyMapper;

    public PropertyService(PropertyRepositoryAdapter propertyRepositoryAdapter, ProjectRepositoryAdapter projectRepositoryAdapter, CollectionRepositoryAdapter collectionRepositoryAdapter, StreetRepositoryAdapter streetRepositoryAdapter, PropertyCategoryRepositoryAdapter propertyCategoryRepositoryAdapter, PropertyMapper propertyMapper) {
        this.propertyRepositoryAdapter = propertyRepositoryAdapter;
        this.projectRepositoryAdapter = projectRepositoryAdapter;
        this.collectionRepositoryAdapter = collectionRepositoryAdapter;
        this.streetRepositoryAdapter = streetRepositoryAdapter;
        this.propertyCategoryRepositoryAdapter = propertyCategoryRepositoryAdapter;
        this.propertyMapper = propertyMapper;
    }

    @Override
    public List<PropertyResponseDTO> getAllPropertiesByProjectId(Long projectId) {
        projectRepositoryAdapter.findById(projectId)
                .orElseThrow(() -> new NoSuchElementException("Project not found with id: " + projectId));

        return propertyRepositoryAdapter.getPropertiesByProjectId(projectId)
                .stream()
                .map(propertyMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PropertyResponseDTO getPropertyById(Long id) {
        return propertyRepositoryAdapter.getPropertyById(id)
                .map(propertyMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Property not found with id: " + id));
    }

    @Override
    public PropertyResponseDTO getPropertyByUUID(UUID uuid) {
        return propertyRepositoryAdapter.getPropertyByUuid(uuid)
                .map(propertyMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Property not found with uuid: " + uuid));
    }

    @Override
    public PropertyResponseDTO createProperty(PropertyCreateRequestDTO propertyCreateRequestDTO) {
        if (propertyRepositoryAdapter.getPropertyByNameAndProjectId(propertyCreateRequestDTO.getName(), propertyCreateRequestDTO.getProjectId()).isPresent()) {
            throw new IllegalArgumentException("Property with name: " + propertyCreateRequestDTO.getName() +
                    " already exists in the project with id: " + propertyCreateRequestDTO.getProjectId());
        }

        ProjectModel projectModel = projectRepositoryAdapter
                .findById(propertyCreateRequestDTO.getProjectId())
                .orElseThrow(() -> new NoSuchElementException("Project not found with id: " + propertyCreateRequestDTO.getProjectId()));

        StreetModel streetModel = streetRepositoryAdapter
                .findById(propertyCreateRequestDTO.getStreetId())
                .orElseThrow(() -> new NoSuchElementException("Street not found with id: " + propertyCreateRequestDTO.getStreetId()));

        CollectionModel collectionModel = null;

        if (propertyCreateRequestDTO.getCollectionId() != null) {
            collectionModel = collectionRepositoryAdapter
                    .findById(propertyCreateRequestDTO.getCollectionId())
                    .orElseThrow(() -> new NoSuchElementException(
                            "Collection not found with id: " + propertyCreateRequestDTO.getCollectionId()));
        }

        PropertyCategoryModel propertyCategoryModel = null;

        if (propertyCreateRequestDTO.getPropertyCategoryId() != null) {
            propertyCategoryModel = propertyCategoryRepositoryAdapter
                    .findById(propertyCreateRequestDTO.getPropertyCategoryId())
                    .orElseThrow(() -> new NoSuchElementException(
                            "Property category not found with id: " + propertyCreateRequestDTO.getPropertyCategoryId()));
        }


        PropertyModel propertyModel = new PropertyModel();

        propertyModel.setId(propertyCreateRequestDTO.getId());
        propertyModel.setUuid(propertyCreateRequestDTO.getUuid());
        propertyModel.setName(propertyCreateRequestDTO.getName());
        propertyModel.setDescription(propertyCreateRequestDTO.getDescription());
        propertyModel.setType(propertyCreateRequestDTO.getType());
        propertyModel.setProject(projectModel);
        propertyModel.setStatus(PropertyStatusEnum.AVAILABLE);

        if (propertyCreateRequestDTO.getCollectionId() != null) {
            propertyModel.setCollection(collectionModel);
        }

        propertyModel.setStreet(streetModel);
        propertyModel.setClient(null);

        if (propertyCreateRequestDTO.getPropertyCategoryId() != null) {
            propertyModel.setPropertyCategory(propertyCategoryModel);
        }

        propertyModel.setUnities(Collections.emptyList());
        propertyModel.setCreatedAt(propertyCreateRequestDTO.getCreatedAt());
        propertyModel.setUpdatedAt(propertyCreateRequestDTO.getUpdatedAt());

        return propertyMapper.toResponseDTO(propertyRepositoryAdapter.save(propertyModel));
    }

    @Override
    public PropertyResponseDTO updateProperty(Long id, PropertyUpdateRequestDTO propertyUpdateRequestDTO) {
        PropertyModel propertyModel = propertyRepositoryAdapter.getPropertyById(id)
                .orElseThrow(() -> new NoSuchElementException("Property not found with id: " + id));

        ProjectModel projectModel = projectRepositoryAdapter.findById(propertyUpdateRequestDTO.getProjectId())
                .orElseThrow(() -> new NoSuchElementException("Project not found with id: " + propertyUpdateRequestDTO.getProjectId()));

        CollectionModel collectionModel = collectionRepositoryAdapter.findById(propertyUpdateRequestDTO.getCollectionId())
                .orElseThrow(() -> new NoSuchElementException("Collection not found with id: " + propertyUpdateRequestDTO.getCollectionId()));

        StreetModel streetModel = streetRepositoryAdapter.findById(propertyUpdateRequestDTO.getStreetId())
                .orElseThrow(() -> new NoSuchElementException("Street not found with id: " + propertyUpdateRequestDTO.getStreetId()));

        PropertyCategoryModel propertyCategoryModel = propertyCategoryRepositoryAdapter.findById(propertyUpdateRequestDTO.getPropertyCategoryId())
                .orElseThrow(() -> new NoSuchElementException("Property category not found with id: " + propertyUpdateRequestDTO.getPropertyCategoryId()));

        if (propertyUpdateRequestDTO.getName() != null) {
            propertyModel.setName(propertyUpdateRequestDTO.getName());
        }
        if (propertyUpdateRequestDTO.getDescription() != null) {
            propertyModel.setDescription(propertyUpdateRequestDTO.getDescription());
        }
        if (propertyUpdateRequestDTO.getType() != null) {
            propertyModel.setType(propertyUpdateRequestDTO.getType());
        }
        if (projectModel != null) {
            propertyModel.setProject(projectModel);
        }
        if (collectionModel != null) {
            propertyModel.setCollection(collectionModel);
        }
        if (streetModel != null) {
            propertyModel.setStreet(streetModel);
        }

        propertyModel.setClient(null);

        if (propertyCategoryModel != null) {
            propertyModel.setPropertyCategory(propertyCategoryModel);
        }
        if (propertyUpdateRequestDTO.getUpdatedAt() != null) {
            propertyModel.setUpdatedAt(propertyUpdateRequestDTO.getUpdatedAt());
        }

        return propertyMapper.toResponseDTO(propertyRepositoryAdapter.save(propertyModel));
    }

    @Override
    public void deleteProperty(Long id) {
        PropertyModel propertyModel = this.propertyRepositoryAdapter.getPropertyById(id)
                .orElseThrow(() -> new NoSuchElementException("Property not found with id: " + id));

        propertyRepositoryAdapter.delete(propertyModel);
    }
}