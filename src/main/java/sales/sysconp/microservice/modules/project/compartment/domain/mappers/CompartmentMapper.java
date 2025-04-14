package sales.sysconp.microservice.modules.project.compartment.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentResponseDTO;
import sales.sysconp.microservice.modules.project.compartment.domain.models.CompartmentModel;
import sales.sysconp.microservice.modules.project.compartment.infrastructure.entities.CompartmentEntity;

@Mapper(componentModel = "spring")
public interface CompartmentMapper {
    @Mapping(target = "unity.property", ignore = true)
    @Mapping(target = "unity.compartments", ignore = true)
    @Mapping(target = "unity.measurement", ignore = true)
    CompartmentModel toModel(CompartmentEntity entity);
    CompartmentEntity toEntity(CompartmentModel model);
    CompartmentResponseDTO toResponseDTO(CompartmentModel model);
}