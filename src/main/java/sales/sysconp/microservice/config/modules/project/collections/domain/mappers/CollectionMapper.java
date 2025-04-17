package sales.sysconp.microservice.config.modules.project.collections.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionResponseDTO;
import sales.sysconp.microservice.modules.project.collections.domain.models.CollectionModel;
import sales.sysconp.microservice.modules.project.collections.infrastructure.entities.CollectionEntity;

@Mapper(componentModel = "spring")
public interface CollectionMapper {
    @Mapping(target = "project", ignore = true)
    @Mapping(target = "properties", ignore = true)
    CollectionModel toModel(CollectionEntity entity);

    CollectionEntity toEntity(CollectionModel model);

    @Mapping(target = "project", ignore = true)
    CollectionResponseDTO toResponseDTO(CollectionModel model);
}
