package sales.sysconp.microservice.modules.project.property_category.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.project.property_category.domain.models.PropertyCategoryModel;
import sales.sysconp.microservice.modules.project.property_category.infrastructure.entities.PropertyCategoryEntity;

@Mapper(componentModel = "spring")
public interface PropertyCategoryMapper {
    PropertyCategoryModel toModel(PropertyCategoryEntity entity);
    PropertyCategoryEntity toEntity(PropertyCategoryModel model);
}