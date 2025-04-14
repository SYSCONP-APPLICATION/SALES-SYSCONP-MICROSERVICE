package sales.sysconp.microservice.modules.project.property_category.application.ports.in;

import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryCreateRequestDTO;
import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryResponseDTO;
import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface PropertyCategoryServiceInPort {
    List<PropertyCategoryResponseDTO> getAllCompanyPropertyCategories(Long companyId);

    PropertyCategoryResponseDTO getPropertyCategoryById(Long id);

    PropertyCategoryResponseDTO getPropertyCategoryByUUID(UUID uuid);

    PropertyCategoryResponseDTO createPropertyCategory(PropertyCategoryCreateRequestDTO propertyCategoryCreateRequestDTO);

    PropertyCategoryResponseDTO updatePropertyCategory(Long id, PropertyCategoryUpdateRequestDTO propertyCategoryUpdateRequestDTO);

    void deletePropertyCategory(Long id);
}