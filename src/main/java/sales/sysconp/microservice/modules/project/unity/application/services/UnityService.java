package sales.sysconp.microservice.modules.project.unity.application.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyStatusEnum;
import sales.sysconp.microservice.modules.project.property.domain.models.PropertyModel;
import sales.sysconp.microservice.modules.project.property.infrastructure.repository.PropertyRepositoryAdapter;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityCreateRequestDTO;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityResponseDTO;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.unity.application.ports.in.UnityServiceInPort;
import sales.sysconp.microservice.modules.project.unity.domain.enums.UnityStatusEnum;
import sales.sysconp.microservice.modules.project.unity.domain.mappers.UnityMapper;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;
import sales.sysconp.microservice.modules.project.unity.infrastructure.repository.UnityRepositoryAdapter;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UnityService implements UnityServiceInPort {
    private final UnityRepositoryAdapter unityRepositoryAdapter;
    private final PropertyRepositoryAdapter propertyRepositoryAdapter;
    private final UnityMapper unityMapper;

    public UnityService(UnityRepositoryAdapter unityRepositoryAdapter, PropertyRepositoryAdapter propertyRepositoryAdapter, UnityMapper unityMapper) {
        this.unityRepositoryAdapter = unityRepositoryAdapter;
        this.propertyRepositoryAdapter = propertyRepositoryAdapter;
        this.unityMapper = unityMapper;
    }

    @Override
    public UnityResponseDTO getUnityById(Long id) {
        UnityModel unityModel = unityRepositoryAdapter.findById(id);

        if (unityModel == null) {
            throw new NoSuchElementException("Unity not found with ID: " + id);
        }

        return unityMapper.toResponseDTO(unityModel);
    }

    @Override
    public UnityResponseDTO getUnityByUuid(UUID uuid) {
        UnityModel unityModel = unityRepositoryAdapter.findByUuid(uuid);

        if (unityModel == null) {
            throw new NoSuchElementException("Unity not found with UUID: " + uuid);
        }

        return unityMapper.toResponseDTO(unityModel);
    }

    @Override
    public List<UnityResponseDTO> getUnitiesByPropertyId(Long propertyId) {
        this.propertyRepositoryAdapter
                .getPropertyById(propertyId)
                .orElseThrow(() -> new NoSuchElementException("Property not found with ID: " + propertyId));

        List<UnityModel> unityModels = unityRepositoryAdapter.findByProperty(propertyId);

        if (unityModels.isEmpty()) {
            throw new IllegalArgumentException("No unities found for property ID " + propertyId);
        }

        return unityModels.stream()
                .map(unityMapper::toResponseDTO)
                .toList();
    }

    @Override
    public UnityResponseDTO createUnity(UnityCreateRequestDTO unityCreateRequestDTO) {
        PropertyModel propertyModel = propertyRepositoryAdapter.getPropertyById(unityCreateRequestDTO.getPropertyId())
                .orElseThrow(() -> new NoSuchElementException("Property not found with ID: " + unityCreateRequestDTO.getPropertyId()));

        UnityModel unityModel = new UnityModel();

        unityModel.setId(unityCreateRequestDTO.getId());
        unityModel.setUuid(unityCreateRequestDTO.getUuid());
        unityModel.setName(unityCreateRequestDTO.getName());
        unityModel.setProperty(propertyModel);
        unityModel.setStatus(UnityStatusEnum.AVAILABLE);
        unityModel.setCreatedAt(unityCreateRequestDTO.getCreatedAt());
        unityModel.setUpdatedAt(unityCreateRequestDTO.getUpdatedAt());

        return unityMapper.toResponseDTO(unityRepositoryAdapter.save(unityModel));
    }

    @Override
    public UnityResponseDTO updateUnity(Long id, UnityUpdateRequestDTO unityUpdateRequestDTO) {
        UnityModel unityModel = unityRepositoryAdapter.findById(id);

        if (unityModel == null) {
            throw new NoSuchElementException("Unity not found with ID: " + id);
        }

        if (unityUpdateRequestDTO.getName() != null) {
            unityModel.setName(unityUpdateRequestDTO.getName());
        }

        if (unityUpdateRequestDTO.getUpdatedAt() != null) {
            unityModel.setUpdatedAt(unityUpdateRequestDTO.getUpdatedAt());
        }

        if (unityUpdateRequestDTO.getUnityStatus() != null) {
            unityModel.setStatus(unityUpdateRequestDTO.getUnityStatus());
        }

        return unityMapper.toResponseDTO(unityRepositoryAdapter.save(unityModel));
    }

    @Override
    public List<UnityResponseDTO> getByPropertyIdAndStatus(Long propertyId, UnityStatusEnum status) {
        this.propertyRepositoryAdapter
                .getPropertyById(propertyId)
                .orElseThrow(() -> new NoSuchElementException("Property not found with ID: " + propertyId));

        List<UnityModel> unityModels = unityRepositoryAdapter.findByPropertyIdAndStatus(propertyId, status);

        if (unityModels.isEmpty()) {
            throw new IllegalArgumentException("No unities found for property ID " + propertyId + " and status " + status);
        }

        return unityModels.stream()
                .map(unityMapper::toResponseDTO)
                .toList();
    }

    @Override
    public UnityResponseDTO changeUnityStatus(Long id, UnityStatusEnum status) {
        UnityModel unityModel = unityRepositoryAdapter.findById(id);

        if (unityModel == null) {
            throw new NoSuchElementException("Unity not found with ID: " + id);
        }

        unityModel.setStatus(status);

        return unityMapper.toResponseDTO(unityRepositoryAdapter.save(unityModel));
    }

    @Transactional
    @Override
    public List<UnityResponseDTO> updateStatusesByIds(List<Long> unityIds, UnityStatusEnum status) {
        int unityModelsUpdated = unityRepositoryAdapter.updateStatusesByIds(unityIds, status);

        if (unityModelsUpdated != unityIds.size()) {
            throw new IllegalArgumentException("Some unities not found to update" + unityIds);
        }

        List<UnityModel> unityModels = unityRepositoryAdapter.findAllById(unityIds);

        Map<Long, List<UnityModel>> unitiesByPropertyId = unityModels.stream()
                .collect(Collectors.groupingBy(unityModel -> unityModel.getProperty().getId()));

        unitiesByPropertyId.forEach((propertyId, propertyUnityModels) -> {
            List<UnityModel> availableUnities = propertyUnityModels.stream()
                    .filter(unityModel -> unityModel.getStatus() == UnityStatusEnum.AVAILABLE)
                    .toList();

            if (availableUnities.isEmpty()) {
                propertyUnityModels.forEach(unityModel -> unityModel.getProperty().setStatus(PropertyStatusEnum.WITHOUT_SPACE));
                propertyRepositoryAdapter.saveAll(propertyUnityModels.stream().map(UnityModel::getProperty).toList());
            }
        });

        return unityModels.stream()
                .map(unityMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void deleteUnity(Long id) {
        UnityModel unityModel = unityRepositoryAdapter.findById(id);

        if (unityModel == null) {
            throw new NoSuchElementException("Unity not found with ID: " + id);
        }

        unityRepositoryAdapter.delete(id);
    }
}
