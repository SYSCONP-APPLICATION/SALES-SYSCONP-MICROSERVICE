package sales.sysconp.microservice.modules.project.unity.application.ports.in;

import sales.sysconp.microservice.modules.project.unity.application.dto.UnityCreateRequestDTO;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityResponseDTO;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface UnityServiceInPort {
    UnityResponseDTO getUnityById(Long id);

    UnityResponseDTO getUnityByUuid(UUID uuid);

    List<UnityResponseDTO> getUnitiesByPropertyId(Long propertyId);

    UnityResponseDTO createUnity(UnityCreateRequestDTO unityCreateRequestDTO);

    UnityResponseDTO updateUnity(Long id, UnityUpdateRequestDTO unityUpdateRequestDTO);

    void deleteUnity(Long id);
}