package sales.sysconp.microservice.config.modules.project.property.application.ports.in;

import sales.sysconp.microservice.modules.project.property.application.dto.PropertyCreateRequestDTO;
import sales.sysconp.microservice.modules.project.property.application.dto.PropertyResponseDTO;
import sales.sysconp.microservice.modules.project.property.application.dto.PropertyUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyStatusEnum;

import java.util.List;
import java.util.UUID;

public interface PropertyServiceInPort {
    List<PropertyResponseDTO> getAllPropertiesByProjectId(Long projectId);

    PropertyResponseDTO getPropertyById(Long id);

    PropertyResponseDTO getPropertyByUUID(UUID uuid);

    PropertyResponseDTO createProperty(PropertyCreateRequestDTO propertyCreateRequestDTO);

    PropertyResponseDTO updatePropertyStatus(Long id, PropertyStatusEnum status);

    PropertyResponseDTO updateProperty(Long id, PropertyUpdateRequestDTO propertyUpdateRequestDTO);

    void deleteProperty(Long id);
}