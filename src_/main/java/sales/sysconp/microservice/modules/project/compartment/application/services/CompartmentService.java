package sales.sysconp.microservice.modules.project.compartment.application.services;

import org.springframework.stereotype.Service;
import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentCreateRequestDTO;
import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentResponseDTO;
import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.compartment.application.ports.in.CompartmentServiceInPort;
import sales.sysconp.microservice.modules.project.compartment.domain.mappers.CompartmentMapper;
import sales.sysconp.microservice.modules.project.compartment.domain.models.CompartmentModel;
import sales.sysconp.microservice.modules.project.compartment.infrastructure.repository.CompartmentRepositoryAdapter;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;
import sales.sysconp.microservice.modules.project.unity.infrastructure.repository.UnityRepositoryAdapter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CompartmentService implements CompartmentServiceInPort {
    private final CompartmentRepositoryAdapter compartmentRepositoryAdapter;
    private final UnityRepositoryAdapter unityRepositoryAdapter;
    private final CompartmentMapper compartmentMapper;

    public CompartmentService(CompartmentRepositoryAdapter compartmentRepositoryAdapter, UnityRepositoryAdapter unityRepositoryAdapter, CompartmentMapper compartmentMapper) {
        this.compartmentRepositoryAdapter = compartmentRepositoryAdapter;
        this.unityRepositoryAdapter = unityRepositoryAdapter;
        this.compartmentMapper = compartmentMapper;
    }

    @Override
    public CompartmentResponseDTO getCompartmentById(Long id) {
        return compartmentMapper.toResponseDTO(compartmentRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Compartment not found with id: " + id)));
    }

    @Override
    public CompartmentResponseDTO getCompartmentByUuid(UUID uuid) {
        return compartmentMapper.toResponseDTO(compartmentRepositoryAdapter
                .findByUuid(uuid)
                .orElseThrow(() -> new NoSuchElementException("Compartment not found with uuid: " + uuid)));
    }

    @Override
    public List<CompartmentResponseDTO> getCompartmentsByUnityId(Long unityId) {
        UnityModel unityModel = unityRepositoryAdapter.findById(unityId);

        if (unityModel == null) {
            throw new NoSuchElementException("Unity not found with ID: " + unityId);
        }

        return unityModel
                .getCompartments()
                .stream()
                .map(compartmentMapper::toResponseDTO)
                .toList();
    }

    @Override
    public CompartmentResponseDTO createCompartment(CompartmentCreateRequestDTO compartmentCreateRequestDTO) {
        UnityModel unityModel = this.unityRepositoryAdapter.findById(compartmentCreateRequestDTO.getUnityId());

        if (unityModel == null) {
            throw new NoSuchElementException("Unity not found with ID: " + compartmentCreateRequestDTO.getUnityId());
        }

        CompartmentModel compartmentModel = new CompartmentModel();

        compartmentModel.setId(compartmentCreateRequestDTO.getId());
        compartmentModel.setUuid(compartmentCreateRequestDTO.getUuid());
        compartmentModel.setDescription(compartmentCreateRequestDTO.getDescription());
        compartmentModel.setHeight(compartmentCreateRequestDTO.getHeight());
        compartmentModel.setWidth(compartmentCreateRequestDTO.getWidth());
        compartmentModel.setHeightMeasurement(compartmentCreateRequestDTO.getHeightMeasurement());
        compartmentModel.setWidthMeasurement(compartmentCreateRequestDTO.getWidthMeasurement());
        compartmentModel.setType(compartmentCreateRequestDTO.getType());
        compartmentModel.setCreatedAt(compartmentCreateRequestDTO.getCreatedAt());
        compartmentModel.setUpdatedAt(compartmentCreateRequestDTO.getUpdatedAt());
        compartmentModel.setUnity(unityModel);

        CompartmentModel createdCompartmentModel = compartmentRepositoryAdapter.save(compartmentModel);

        return compartmentMapper.toResponseDTO(createdCompartmentModel);
    }

    @Override
    public CompartmentResponseDTO updateCompartment(Long id, CompartmentUpdateRequestDTO compartmentUpdateRequestDTO) {
        CompartmentModel compartmentModel = compartmentRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Compartment not found with id: " + id));

        if (compartmentUpdateRequestDTO.getDescription() != null) {
            compartmentModel.setDescription(compartmentUpdateRequestDTO.getDescription());
        }

        if (compartmentUpdateRequestDTO.getHeight() != null) {
            compartmentModel.setHeight(compartmentUpdateRequestDTO.getHeight());
        }

        if (compartmentUpdateRequestDTO.getWidth() != null) {
            compartmentModel.setWidth(compartmentUpdateRequestDTO.getWidth());
        }

        if (compartmentUpdateRequestDTO.getHeightMeasurement() != null) {
            compartmentModel.setHeightMeasurement(compartmentUpdateRequestDTO.getHeightMeasurement());
        }

        if (compartmentUpdateRequestDTO.getWidthMeasurement() != null) {
            compartmentModel.setWidthMeasurement(compartmentUpdateRequestDTO.getWidthMeasurement());
        }

        if (compartmentUpdateRequestDTO.getType() != null) {
            compartmentModel.setType(compartmentUpdateRequestDTO.getType());
        }

        CompartmentModel updatedCompartmentModel = compartmentRepositoryAdapter.save(compartmentModel);

        return compartmentMapper.toResponseDTO(updatedCompartmentModel);
    }

    @Override
    public void deleteCompartment(Long id) {
        compartmentRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Compartment not found with id: " + id));
        compartmentRepositoryAdapter.delete(id);
    }
}
