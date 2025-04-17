package sales.sysconp.microservice.featuresd.client.application.ports.out;

import sales.sysconp.microservice.features.client.domain.models.ClientModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepositoryOutPort {
    List<ClientModel> findAllByCompanyId(Long companyId);

    Optional<ClientModel> findById(Long id);

    Optional<ClientModel> findByIdAndCompanyId(Long id, Long companyId);

    Optional<ClientModel> findByUUID(UUID uuid);

    Optional<ClientModel> findByIdentityCardNumberAndCompanyId(String identityCardNumber, Long companyId);

    ClientModel save(ClientModel clientModel);

    void deleteById(Long id);
}