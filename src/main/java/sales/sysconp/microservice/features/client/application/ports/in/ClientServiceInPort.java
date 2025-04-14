package sales.sysconp.microservice.features.client.application.ports.in;

import sales.sysconp.microservice.features.client.application.dto.ClientCreateRequestDTO;
import sales.sysconp.microservice.features.client.application.dto.ClientResponseDTO;
import sales.sysconp.microservice.features.client.application.dto.ClientUpdateRequestDTO;
import sales.sysconp.microservice.features.client.domain.models.ClientModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientServiceInPort {
    List<ClientResponseDTO> getAllClientsByCompanyId(Long companyId);

    ClientResponseDTO getClientById(Long id);

    ClientResponseDTO getClientByUUID(UUID uuid);

    ClientResponseDTO createClient(ClientCreateRequestDTO clientCreateRequestDTO);

    ClientResponseDTO updateClient(Long id, ClientUpdateRequestDTO clientUpdateRequestDTO);

    void deleteClientById(Long id);
}