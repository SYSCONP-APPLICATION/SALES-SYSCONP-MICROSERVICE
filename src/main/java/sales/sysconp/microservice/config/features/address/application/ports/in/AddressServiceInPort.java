package sales.sysconp.microservice.config.features.address.application.ports.in;

import sales.sysconp.microservice.features.address.application.dto.AddressCreateRequestDTO;
import sales.sysconp.microservice.features.address.application.dto.AddressResponseDTO;
import sales.sysconp.microservice.features.address.application.dto.AddressUpdateRequestDTO;

import java.util.Optional;
import java.util.UUID;

public interface AddressServiceInPort {
    AddressResponseDTO createAddress(AddressCreateRequestDTO addressCreateRequestDTO);

    AddressResponseDTO updateAddress(Long id, AddressUpdateRequestDTO addressUpdateRequestDTO);

    AddressResponseDTO getAddressById(Long id);

    AddressResponseDTO getAddressByUUID(UUID uuid);

    AddressResponseDTO getAddressByClientId(Long clientId);

    void deleteAddress(Long id);
}
