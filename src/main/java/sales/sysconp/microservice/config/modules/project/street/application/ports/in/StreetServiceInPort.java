package sales.sysconp.microservice.config.modules.project.street.application.ports.in;

import sales.sysconp.microservice.modules.project.street.application.dto.StreetCreateRequestDTO;
import sales.sysconp.microservice.modules.project.street.application.dto.StreetResponseDTO;
import sales.sysconp.microservice.modules.project.street.application.dto.StreetUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface StreetServiceInPort {
    List<StreetResponseDTO> getAllStreetsByProjectId(Long projectId);

    StreetResponseDTO getStreetById(Long streetId);

    StreetResponseDTO getStreetByUuid(UUID uuid);

    StreetResponseDTO createStreet(StreetCreateRequestDTO streetCreateRequestDTO);

    StreetResponseDTO updateStreet(Long id, StreetUpdateRequestDTO streetUpdateRequestDTO);

    void deleteStreet(Long streetId);
}