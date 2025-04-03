package sales.sysconp.microservice.modules.project.project.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;
import sales.sysconp.microservice.modules.project.project.infrastructure.entities.ProjectEntity;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectModel toModel(ProjectEntity entity);
    ProjectEntity toEntity(ProjectModel model);
}
