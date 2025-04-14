package sales.sysconp.microservice.features.client.application.services;

import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.client.application.dto.ClientCreateRequestDTO;
import sales.sysconp.microservice.features.client.application.dto.ClientResponseDTO;
import sales.sysconp.microservice.features.client.application.dto.ClientUpdateRequestDTO;
import sales.sysconp.microservice.features.client.application.ports.in.ClientServiceInPort;
import sales.sysconp.microservice.features.client.domain.mappers.ClientMapper;
import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.features.client.infrastructure.repository.ClientRepositoryAdapter;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.repository.CompanyRepositoryAdapter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService implements ClientServiceInPort {
    private final ClientRepositoryAdapter clientRepositoryAdapter;
    private final CompanyRepositoryAdapter companyRepositoryAdapter;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepositoryAdapter clientRepositoryAdapter, CompanyRepositoryAdapter companyRepositoryAdapter, ClientMapper clientMapper) {
        this.clientRepositoryAdapter = clientRepositoryAdapter;
        this.companyRepositoryAdapter = companyRepositoryAdapter;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientResponseDTO> getAllClientsByCompanyId(Long companyId) {
        this.companyRepositoryAdapter
                .findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company not found with id: " + companyId));

        return clientRepositoryAdapter.findAllByCompanyId(companyId).stream()
                .map(this.clientMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ClientResponseDTO getClientById(Long id) {
        ClientModel clientModel = this.clientRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Client not found with id: " + id));

        return this.clientMapper.toResponseDTO(clientModel);
    }

    @Override
    public ClientResponseDTO getClientByUUID(UUID uuid) {
        ClientModel clientModel = this.clientRepositoryAdapter
                .findByUUID(uuid)
                .orElseThrow(() -> new NoSuchElementException("Client not found with id: " + uuid));

        return this.clientMapper.toResponseDTO(clientModel);
    }

    @Override
    public ClientResponseDTO createClient(ClientCreateRequestDTO clientCreateRequestDTO) {
        CompanyModel companyModel = this.companyRepositoryAdapter
                .findById(clientCreateRequestDTO.getCompanyId())
                .orElseThrow(() -> new NoSuchElementException("Company not found with id: " + clientCreateRequestDTO.getCompanyId()));

        this.clientRepositoryAdapter
                .findByIdentityCardNumberAndCompanyId(clientCreateRequestDTO.getIdentityCardNumber(), clientCreateRequestDTO.getCompanyId())
                .ifPresent(client -> {
                    throw new IllegalArgumentException("Client with identity card number " + clientCreateRequestDTO.getIdentityCardNumber() + " already exists");
                });

        ClientModel clientModel = new ClientModel();

        clientModel.setName(clientCreateRequestDTO.getName());
        clientModel.setIdentityCardNumber(clientCreateRequestDTO.getIdentityCardNumber());
        clientModel.setCompany(companyModel);

        return clientMapper.toResponseDTO(clientRepositoryAdapter.save(clientModel));
    }

    @Override
    public ClientResponseDTO updateClient(Long id, ClientUpdateRequestDTO clientUpdateRequestDTO) {
        ClientModel clientModel = clientRepositoryAdapter.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Client not found with id: " + id));

        Optional<ClientModel> clientByIdentityCardNumber = clientRepositoryAdapter
                .findByIdentityCardNumberAndCompanyId(clientUpdateRequestDTO.getIdentityCardNumber(), clientModel.getCompany().getId());

        if (clientByIdentityCardNumber.isPresent() && !clientByIdentityCardNumber.get().getId().equals(id)) {
            throw new IllegalArgumentException("Client with identity card number " + clientUpdateRequestDTO.getIdentityCardNumber() + " already exists");
        }

        if (clientUpdateRequestDTO.getName() != null) {
            clientModel.setName(clientUpdateRequestDTO.getName());
        }

        if (clientUpdateRequestDTO.getIdentityCardNumber() != null) {
            clientModel.setIdentityCardNumber(clientUpdateRequestDTO.getIdentityCardNumber());
        }

        return this.clientMapper.toResponseDTO(this.clientRepositoryAdapter.save(clientModel));
    }

    @Override
    public void deleteClientById(Long id) {
        this.clientRepositoryAdapter.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Client not found with id: " + id));

        this.clientRepositoryAdapter.deleteById(id);
    }
}