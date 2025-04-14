package sales.sysconp.microservice.modules.project.street.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.modules.project.street.application.dto.StreetResponseDTO;
import sales.sysconp.microservice.modules.project.street.domain.models.StreetModel;
import sales.sysconp.microservice.modules.project.street.infrastructure.entities.StreetEntity;

@Mapper(componentModel = "spring")
public interface StreetMapper {
    @Mapping(target = "properties", ignore = true)
    @Mapping(target = "project.streets", ignore = true)
    @Mapping(target = "project.properties", ignore = true)
    @Mapping(target = "project.collections", ignore = true)
    @Mapping(target = "project.company", ignore = true)
    StreetModel toModel(StreetEntity entity);

    StreetEntity toEntity(StreetModel model);

    StreetResponseDTO toResponseDTO(StreetModel model);
}
