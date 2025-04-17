package sales.sysconp.microservice.config.modules.project.measurements.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.modules.project.measurements.infrastructure.entities.MeasurementEntity;

import java.util.Optional;
import java.util.UUID;

public interface JPAMeasurementRepository extends JpaRepository<MeasurementEntity, Long> {
    Optional<MeasurementEntity> findByUuid(UUID uuid);

    MeasurementEntity findByUnityId(Long unityId);
}