package sales.sysconp.microservice.modules.project.building.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.project.building.domain.models.BuildingModel;
import sales.sysconp.microservice.modules.project.building.infrastructure.entities.BuildingEntity;

@Mapper(componentModel = "spring", uses = { })
public interface BuildingMapper {
    BuildingModel toModel(BuildingEntity entity);
    BuildingEntity toEntity(BuildingModel entity);
}