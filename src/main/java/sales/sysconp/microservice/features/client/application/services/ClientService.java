package sales.sysconp.microservice.features.client.application.services;

import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.client.application.dto.ClientCreateRequestDTO;
import sales.sysconp.microservice.features.client.application.dto.ClientResponseDTO;
import sales.sysconp.microservice.features.client.application.dto.ClientUpdateRequestDTO;
import sales.sysconp.microservice.features.client.application.ports.in.ClientServiceInPort;
import sales.sysconp.microservice.features.client.domain.models.ClientModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService implements ClientServiceInPort {

    @Override
    public List<ClientResponseDTO> getAllClientsByCompanyId(Long companyId) {
        return List.of();
    }

    @Override
    public Optional<ClientResponseDTO> getClientById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ClientResponseDTO> getClientByUUID(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Optional<ClientResponseDTO> findByNameAndCompanyId(String name) {
        return Optional.empty();
    }

    @Override
    public ClientModel createClient(ClientCreateRequestDTO clientCreateRequestDTO) {
        return null;
    }

    @Override
    public ClientModel updateClient(ClientUpdateRequestDTO clientUpdateRequestDTO) {
        return null;
    }

    @Override
    public void deleteClientById(Long id) {

    }
}
