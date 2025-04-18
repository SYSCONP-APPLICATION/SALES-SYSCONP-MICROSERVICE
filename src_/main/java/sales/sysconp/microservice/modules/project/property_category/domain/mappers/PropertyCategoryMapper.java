package sales.sysconp.microservice.modules.project.property_category.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryResponseDTO;
import sales.sysconp.microservice.modules.project.property_category.domain.models.PropertyCategoryModel;
import sales.sysconp.microservice.modules.project.property_category.infrastructure.entities.PropertyCategoryEntity;

@Mapper(componentModel = "spring")
public interface PropertyCategoryMapper {
    @Mapping(target = "company.propertyCategories", ignore = true)
    @Mapping(target = "company.users", ignore = true)
    @Mapping(target = "company.projects", ignore = true)
    @Mapping(target = "properties", ignore = true)
    PropertyCategoryModel toModel(PropertyCategoryEntity entity);

    @Mapping(target = "company.propertyCategories", ignore = true)
    @Mapping(target = "company.users", ignore = true)
    @Mapping(target = "company.projects", ignore = true)
    @Mapping(target = "properties", ignore = true)
    PropertyCategoryEntity toEntity(PropertyCategoryModel model);

    @Mapping(target = "company.propertyCategories", ignore = true)
    @Mapping(target = "company.users", ignore = true)
    @Mapping(target = "company.projects", ignore = true)
    PropertyCategoryResponseDTO toResponseDTO(PropertyCategoryModel model);
}