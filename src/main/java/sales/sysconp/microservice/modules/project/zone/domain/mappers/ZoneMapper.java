package sales.sysconp.microservice.modules.project.zone.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.project.zone.domain.models.ZoneModel;
import sales.sysconp.microservice.modules.project.zone.infrastructure.entities.ZoneEntity;

@Mapper(componentModel = "spring")
public interface ZoneMapper {
    ZoneModel toModel(ZoneEntity entity);
    ZoneEntity toEntity(ZoneModel model);
}