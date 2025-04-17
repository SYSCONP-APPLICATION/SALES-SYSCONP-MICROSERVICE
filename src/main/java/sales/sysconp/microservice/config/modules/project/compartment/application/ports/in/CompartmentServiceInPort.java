package sales.sysconp.microservice.config.modules.project.compartment.application.ports.in;

import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentCreateRequestDTO;
import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentResponseDTO;
import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface CompartmentServiceInPort {
    CompartmentResponseDTO getCompartmentById(Long id);

    CompartmentResponseDTO getCompartmentByUuid(UUID uuid);

    List<CompartmentResponseDTO> getCompartmentsByUnityId(Long unityId);

    CompartmentResponseDTO createCompartment(CompartmentCreateRequestDTO compartmentCreateRequestDTO);

    CompartmentResponseDTO updateCompartment(Long id, CompartmentUpdateRequestDTO compartmentUpdateRequestDTO);

    void deleteCompartment(Long id);
}