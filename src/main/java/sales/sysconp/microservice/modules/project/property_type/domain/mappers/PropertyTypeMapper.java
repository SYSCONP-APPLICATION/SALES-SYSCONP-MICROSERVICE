package sales.sysconp.microservice.modules.project.property_type.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.project.property_type.domain.models.PropertyTypeModel;
import sales.sysconp.microservice.modules.project.property_type.infrastructure.entities.PropertyTypeEntity;

@Mapper(componentModel = "spring")
public interface PropertyTypeMapper {
    PropertyTypeModel toModel(PropertyTypeEntity entity);
    PropertyTypeEntity toEntity(PropertyTypeModel model);
}