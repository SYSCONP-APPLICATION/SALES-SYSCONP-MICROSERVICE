package sales.sysconp.microservice.features.address.application.ports.out;

import sales.sysconp.microservice.features.address.domain.models.AddressModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AddressRepositoryOutPort {
    Optional<AddressModel> findById(Long id);

    Optional<AddressModel> findByUUID(UUID uuid);

    List<AddressModel> findByClientId(Long clientId);

    AddressModel save(AddressModel addressModel);

    void deleteById(Long id);
}