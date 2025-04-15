package sales.sysconp.microservice.modules.project.property.application.ports.out;

import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyStatusEnum;
import sales.sysconp.microservice.modules.project.property.domain.models.PropertyModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PropertyRepositoryOutPort {
    Optional<PropertyModel> getPropertyByUuid(UUID uuid);

    Optional<PropertyModel> getPropertyById(Long id);

    List<PropertyModel> getPropertiesByProjectId(Long projectId);

    List<PropertyModel> getPropertiesByCollectionId(Long collectionId);

    List<PropertyModel> getPropertiesByStreetId(Long streetId);

    List<PropertyModel> getPropertiesByPropertyCategoryId(Long propertyCategoryId);

    Optional<PropertyModel> getPropertyByNameAndProjectId(String name, Long projectId);

    Optional<PropertyModel> getPropertyByIdAndProjectId(Long id, Long projectId);

    List<PropertyModel> saveAll(List<PropertyModel> propertyModels);

    Optional<PropertyModel> getPropertyByUuidAndProjectId(UUID uuid, Long projectId);

    PropertyModel save(PropertyModel propertyModel);

    void delete(PropertyModel propertyModel);

    List<PropertyModel> getPropertiesByStatus(PropertyStatusEnum status);
}