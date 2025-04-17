package sales.sysconp.microservice.config.modules.project.measurements.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.modules.project.measurements.application.ports.out.MeasurementRepositoryOutPort;
import sales.sysconp.microservice.modules.project.measurements.domain.mappers.MeasurementsMapper;
import sales.sysconp.microservice.modules.project.measurements.domain.models.MeasurementModel;
import sales.sysconp.microservice.modules.project.measurements.infrastructure.repository.JPAMeasurementRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class MeasurementRepositoryAdapter implements MeasurementRepositoryOutPort {
    private final sales.sysconp.microservice.modules.project.measurements.infrastructure.repository.JPAMeasurementRepository jpaRepository;
    private final MeasurementsMapper measurementMapper;

    public MeasurementRepositoryAdapter(JPAMeasurementRepository jpaRepository, MeasurementsMapper measurementMapper) {
        this.jpaRepository = jpaRepository;
        this.measurementMapper = measurementMapper;
    }

    @Override
    public Optional<MeasurementModel> findById(Long id) {
        return jpaRepository.findById(id).map(measurementMapper::toModel);
    }

    @Override
    public Optional<MeasurementModel> findByUuid(UUID uuid) {
        return jpaRepository.findByUuid(uuid).map(measurementMapper::toModel);
    }

    @Override
    public MeasurementModel findByUnityId(Long id) {
        return this.measurementMapper.toModel(jpaRepository.findByUnityId(id));
    }

    @Override
    public MeasurementModel save(MeasurementModel measurementModel) {
        return measurementMapper.toModel(jpaRepository.save(measurementMapper.toEntity(measurementModel)));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}