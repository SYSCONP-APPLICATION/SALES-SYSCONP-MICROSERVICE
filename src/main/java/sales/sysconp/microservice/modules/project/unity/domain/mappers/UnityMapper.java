package sales.sysconp.microservice.modules.project.unity.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;
import sales.sysconp.microservice.modules.project.unity.infrastructure.entities.UnityEntity;

@Mapper(componentModel = "spring")
public interface UnityMapper {
    UnityModel toModel(UnityEntity entity);
    UnityEntity toEntity(UnityModel model);
}
