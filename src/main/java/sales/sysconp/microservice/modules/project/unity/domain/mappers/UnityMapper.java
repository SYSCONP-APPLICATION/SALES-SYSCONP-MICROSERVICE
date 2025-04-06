package sales.sysconp.microservice.modules.project.unity.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.modules.project.compartment.domain.mappers.CompartmentMapper;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityResponseDTO;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;
import sales.sysconp.microservice.modules.project.unity.infrastructure.entities.UnityEntity;

@Mapper(componentModel = "spring", uses = { CompartmentMapper.class })
public interface UnityMapper {
    @Mapping(target = "measurement.unity", ignore = true)
    @Mapping(target = "property.project", ignore = true)
    @Mapping(target = "property.collection", ignore = true)
    @Mapping(target = "property.street", ignore = true)
    @Mapping(target = "property.propertyCategory", ignore = true)
    @Mapping(target = "property.unities", ignore = true)
    UnityModel toModel(UnityEntity entity);
    UnityEntity toEntity(UnityModel model);
    UnityResponseDTO toResponseDTO(UnityModel model);

}
