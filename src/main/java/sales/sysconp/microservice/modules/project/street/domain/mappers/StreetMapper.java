package sales.sysconp.microservice.modules.project.street.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.project.street.domain.models.StreetModel;
import sales.sysconp.microservice.modules.project.street.infrastructure.entities.StreetEntity;

@Mapper(componentModel = "spring")
public interface StreetMapper {
    StreetModel toModel(StreetEntity entity);
    StreetEntity toEntity(StreetModel model);
}
