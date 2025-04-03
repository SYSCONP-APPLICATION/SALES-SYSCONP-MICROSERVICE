package sales.sysconp.microservice.modules.project.measurements.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.project.measurements.domain.models.MeasurementModel;
import sales.sysconp.microservice.modules.project.measurements.infrastructure.entities.MeasurementEntity;

@Mapper(componentModel = "spring")
public interface MeasurementsMapper {
    MeasurementModel toModel(MeasurementEntity entity);
    MeasurementEntity toEntity(MeasurementModel model);
}
