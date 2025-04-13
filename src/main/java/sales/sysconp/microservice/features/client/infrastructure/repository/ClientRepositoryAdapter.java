package sales.sysconp.microservice.features.client.infrastructure.repository;

import sales.sysconp.microservice.features.client.application.ports.out.ClientRepositoryOutPort;
import sales.sysconp.microservice.features.client.domain.mappers.ClientMapper;
import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientRepositoryAdapter implements ClientRepositoryOutPort {

    private final JPAClientRepository jpaRepository;
    private final ClientMapper clientMapper;

    public ClientRepositoryAdapter(JPAClientRepository jpaRepository, ClientMapper clientMapper) {
        this.jpaRepository = jpaRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientModel> findAllByCompanyId(Long companyId) {
        return jpaRepository.findByCompanyId(companyId)
                .stream()
                .map(clientMapper::toModel)
                .toList();
    }

    @Override
    public Optional<ClientModel> findById(Long id) {
        return jpaRepository.findById(id)
                .map(clientMapper::toModel);
    }

    @Override
    public Optional<ClientModel> findByUUID(UUID uuid) {
        return jpaRepository.findByUuid(uuid)
                .map(clientMapper::toModel);
    }

    @Override
    public Optional<ClientModel> findByIdentityCardNumberAndCompanyId(String identityCardNumber, Long companyId) {
        return jpaRepository.findByIdentityCardNumberAndCompanyId(identityCardNumber, companyId)
                .map(clientMapper::toModel);
    }

    @Override
    public ClientModel save(ClientModel clientModel) {
        ClientEntity clientEntity = clientMapper.toEntity(clientModel);
        return clientMapper.toModel(jpaRepository.save(clientEntity));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
