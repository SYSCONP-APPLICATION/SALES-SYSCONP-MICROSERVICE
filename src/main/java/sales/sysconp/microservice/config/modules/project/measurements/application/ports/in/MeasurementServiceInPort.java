package sales.sysconp.microservice.config.modules.project.measurements.application.ports.in;

import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementCreateRequestDTO;
import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementResponseDTO;
import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementUpdateRequestDTO;

import java.util.UUID;

public interface MeasurementServiceInPort {
    MeasurementResponseDTO getMeasurementById(Long id);

    MeasurementResponseDTO getMeasurementByUuid(UUID uuid);

    MeasurementResponseDTO createMeasurement(MeasurementCreateRequestDTO measurementCreateRequestDTO);

    MeasurementResponseDTO updateMeasurement(Long id, MeasurementUpdateRequestDTO measurementUpdateRequestDTO);

    MeasurementResponseDTO getMeasurementByUnityId(Long id);

    void deleteMeasurement(Long id);
}
