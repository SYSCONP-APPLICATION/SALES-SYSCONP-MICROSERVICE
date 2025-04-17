package sales.sysconp.microservice.config.modules.project.measurements.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementResponseDTO;
import sales.sysconp.microservice.modules.project.measurements.domain.models.MeasurementModel;
import sales.sysconp.microservice.modules.project.measurements.infrastructure.entities.MeasurementEntity;
import sales.sysconp.microservice.modules.project.unity.domain.mappers.UnityMapper;

@Mapper(componentModel = "spring", uses = { UnityMapper.class })
public interface MeasurementsMapper {
    MeasurementModel toModel(MeasurementEntity entity);
    MeasurementEntity toEntity(MeasurementModel model);
    MeasurementResponseDTO toResponseDTO(MeasurementModel model);
}
