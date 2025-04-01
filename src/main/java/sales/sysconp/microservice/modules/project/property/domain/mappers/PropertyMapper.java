package sales.sysconp.microservice.modules.project.property.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.project.property.domain.models.PropertyModel;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;

@Mapper(componentModel = "spring")
public interface PropertyMapper {
    PropertyModel toModel(PropertyEntity entity);
    PropertyEntity toEntity(PropertyModel model);
}