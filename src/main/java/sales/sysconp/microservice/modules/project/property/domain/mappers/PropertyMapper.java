package sales.sysconp.microservice.modules.project.property.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.modules.project.property.application.dto.PropertyResponseDTO;
import sales.sysconp.microservice.modules.project.property.domain.models.PropertyModel;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;

@Mapper(componentModel = "spring")
public interface PropertyMapper {
    @Mapping(target = "project.properties", ignore = true)
    @Mapping(target = "project.streets", ignore = true)
    @Mapping(target = "project.collections", ignore = true)
    @Mapping(target = "project.company", ignore = true)
    @Mapping(target = "collection.properties", ignore = true)
    @Mapping(target = "collection.project", ignore = true)
    @Mapping(target = "street.properties", ignore = true)
    @Mapping(target = "street.project", ignore = true)
    @Mapping(target = "propertyCategory.properties", ignore = true)
    @Mapping(target = "propertyCategory.company", ignore = true)
    PropertyModel toModel(PropertyEntity entity);
    PropertyEntity toEntity(PropertyModel model);

    PropertyResponseDTO toResponseDTO(PropertyModel model);
}
