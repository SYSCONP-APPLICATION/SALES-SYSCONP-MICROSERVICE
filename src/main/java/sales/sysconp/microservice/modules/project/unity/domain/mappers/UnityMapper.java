package sales.sysconp.microservice.modules.project.unity.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityResponseDTO;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;
import sales.sysconp.microservice.modules.project.unity.infrastructure.entities.UnityEntity;

@Mapper(componentModel = "spring")
public interface UnityMapper {
    @Mapping(target = "property", ignore = true)
    @Mapping(target = "measurement.unity", ignore = true)
    @Mapping(target = "compartments.unity", ignore = true)
    UnityModel toModel(UnityEntity entity);
    UnityEntity toEntity(UnityModel model);
    UnityResponseDTO toResponseDTO(UnityModel model);
}
