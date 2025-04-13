package sales.sysconp.microservice.features.address.application.ports.in;

import sales.sysconp.microservice.features.address.application.dto.AddressCreateRequestDTO;
import sales.sysconp.microservice.features.address.application.dto.AddressResponseDTO;
import sales.sysconp.microservice.features.address.application.dto.AddressUpdateRequestDTO;

import java.util.Optional;
import java.util.UUID;

public interface AddressServiceInPort {
    AddressResponseDTO createAddress(AddressCreateRequestDTO addressCreateRequestDTO);

    AddressResponseDTO updateAddress(Long id, AddressUpdateRequestDTO addressUpdateRequestDTO);

    Optional<AddressResponseDTO> getAddressById(Long id);

    Optional<AddressResponseDTO> getAddressByUUID(UUID uuid);

    Optional<AddressResponseDTO> getAddressByClientId(Long clientId);

    void deleteAddress(Long id);
}
