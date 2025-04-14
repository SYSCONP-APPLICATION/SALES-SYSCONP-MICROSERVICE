package sales.sysconp.microservice.modules.project.measurements.application.services;

import org.springframework.stereotype.Service;
import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementCreateRequestDTO;
import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementResponseDTO;
import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.measurements.application.ports.in.MeasurementServiceInPort;
import sales.sysconp.microservice.modules.project.measurements.domain.mappers.MeasurementsMapper;
import sales.sysconp.microservice.modules.project.measurements.domain.models.MeasurementModel;
import sales.sysconp.microservice.modules.project.measurements.infrastructure.repository.MeasurementRepositoryAdapter;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;
import sales.sysconp.microservice.modules.project.unity.infrastructure.repository.UnityRepositoryAdapter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class MeasurementService implements MeasurementServiceInPort {
    private final UnityRepositoryAdapter unityRepositoryAdapter;
    private final MeasurementRepositoryAdapter measurementRepositoryAdapter;
    private final MeasurementsMapper measurementMapper;

    public MeasurementService(UnityRepositoryAdapter unityRepositoryAdapter, MeasurementRepositoryAdapter measurementRepositoryAdapter, MeasurementsMapper measurementMapper) {
        this.unityRepositoryAdapter = unityRepositoryAdapter;
        this.measurementRepositoryAdapter = measurementRepositoryAdapter;
        this.measurementMapper = measurementMapper;
    }

    @Override
    public MeasurementResponseDTO getMeasurementById(Long id) {
        return measurementRepositoryAdapter.findById(id)
                .map(measurementMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Medição não encontrada!"));
    }

    @Override
    public MeasurementResponseDTO getMeasurementByUuid(UUID uuid) {
        return measurementRepositoryAdapter.findByUuid(uuid)
                .map(measurementMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Medição não encontrada!"));
    }

    @Override
    public MeasurementResponseDTO createMeasurement(MeasurementCreateRequestDTO measurementCreateRequestDTO) {
        UnityModel unityModel = unityRepositoryAdapter.findById(measurementCreateRequestDTO.getUnityId());

        if (unityModel == null) {
            throw new NoSuchElementException("Unity not found with ID: " + measurementCreateRequestDTO.getUnityId());
        }

        MeasurementModel measurementModelByUnity = measurementRepositoryAdapter.findByUnityId(measurementCreateRequestDTO.getUnityId());

        if (measurementModelByUnity != null) {
            throw new IllegalArgumentException("Unity already has a measurement!");
        }

        MeasurementModel measurementModel = new MeasurementModel();

        measurementModel.setId(measurementCreateRequestDTO.getId());
        measurementModel.setUuid(measurementCreateRequestDTO.getUuid());
        measurementModel.setHeight(measurementCreateRequestDTO.getHeight());
        measurementModel.setWidth(measurementCreateRequestDTO.getWidth());
        measurementModel.setHeightMeasurement(measurementCreateRequestDTO.getHeightMeasurement());
        measurementModel.setWidthMeasurement(measurementCreateRequestDTO.getWidthMeasurement());
        measurementModel.setUnity(unityModel);
        measurementModel.setCreatedAt(measurementCreateRequestDTO.getCreatedAt());
        measurementModel.setUpdatedAt(measurementCreateRequestDTO.getUpdatedAt());

        return measurementMapper.toResponseDTO(measurementRepositoryAdapter.save(measurementModel));
    }

    @Override
    public MeasurementResponseDTO updateMeasurement(Long id, MeasurementUpdateRequestDTO measurementUpdateRequestDTO) {
        MeasurementModel existingMeasurement = measurementRepositoryAdapter.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Measurement not found with ID: " + id));

        if (measurementUpdateRequestDTO.getHeight() != null) {
            existingMeasurement.setHeight(measurementUpdateRequestDTO.getHeight());
        }

        if (measurementUpdateRequestDTO.getWidth() != null) {
            existingMeasurement.setWidth(measurementUpdateRequestDTO.getWidth());
        }

        if (measurementUpdateRequestDTO.getHeightMeasurement() != null) {
            existingMeasurement.setHeightMeasurement(measurementUpdateRequestDTO.getHeightMeasurement());
        }

        if (measurementUpdateRequestDTO.getWidthMeasurement() != null) {
            existingMeasurement.setWidthMeasurement(measurementUpdateRequestDTO.getWidthMeasurement());
        }

        if (measurementUpdateRequestDTO.getUpdatedAt() != null) {
            existingMeasurement.setUpdatedAt(measurementUpdateRequestDTO.getUpdatedAt());
        }

        return measurementMapper.toResponseDTO(measurementRepositoryAdapter.save(existingMeasurement));
    }

    @Override
    public MeasurementResponseDTO getMeasurementByUnityId(Long id) {
        UnityModel unityModelById = this.unityRepositoryAdapter.findById(id);

        if (unityModelById == null) {
            throw new NoSuchElementException("Unity not found with ID: " + id);
        }

        return measurementMapper.toResponseDTO(measurementRepositoryAdapter.findByUnityId(id));
    }

    @Override
    public void deleteMeasurement(Long id) {
        MeasurementModel measurement = measurementRepositoryAdapter.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Measurement not found with ID: " + id));

        measurementRepositoryAdapter.delete(measurement.getId());
    }
}
