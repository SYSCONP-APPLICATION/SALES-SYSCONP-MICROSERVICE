package sales.sysconp.microservice.modules.project.project.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.modules.project.project.application.dto.ProjectResponseDTO;
import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;
import sales.sysconp.microservice.modules.project.project.infrastructure.entities.ProjectEntity;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "properties", ignore = true)
    @Mapping(target = "streets", ignore = true)
    @Mapping(target = "collections", ignore = true)
    ProjectModel toModel(ProjectEntity entity);

    ProjectEntity toEntity(ProjectModel model);

    ProjectResponseDTO toResponseDTO(ProjectModel model);
}
