package sales.sysconp.microservice.modules.project.compartment.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.project.compartment.domain.models.CompartmentModel;
import sales.sysconp.microservice.modules.project.compartment.infrastructure.entities.CompartmentEntity;

@Mapper(componentModel = "spring")
public interface CompartmentMapper {
    CompartmentModel toModel(CompartmentEntity entity);
    CompartmentEntity toEntity(CompartmentModel model);
}
