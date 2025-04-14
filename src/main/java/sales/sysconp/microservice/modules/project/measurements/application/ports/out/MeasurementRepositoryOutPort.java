package sales.sysconp.microservice.modules.project.measurements.application.ports.out;

import sales.sysconp.microservice.modules.project.measurements.domain.models.MeasurementModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MeasurementRepositoryOutPort {
    Optional<MeasurementModel> findById(Long id);

    Optional<MeasurementModel> findByUuid(UUID uuid);

    MeasurementModel findByUnityId(Long id);

    MeasurementModel save(MeasurementModel measurementModel);

    void delete(Long id);
}