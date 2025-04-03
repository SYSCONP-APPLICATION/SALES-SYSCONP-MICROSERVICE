package sales.sysconp.microservice.modules.project.collections.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.project.collections.domain.models.CollectionModel;
import sales.sysconp.microservice.modules.project.collections.infrastructure.entities.CollectionEntity;

@Mapper(componentModel = "spring")
public interface CollectionMapper {
    CollectionModel toModel(CollectionEntity entity);
    CollectionEntity toEntity(CollectionModel model);
}
