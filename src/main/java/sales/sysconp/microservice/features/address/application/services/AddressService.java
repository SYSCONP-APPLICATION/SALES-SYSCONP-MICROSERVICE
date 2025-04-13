package sales.sysconp.microservice.features.address.application.services;

import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.address.application.dto.AddressCreateRequestDTO;
import sales.sysconp.microservice.features.address.application.dto.AddressResponseDTO;
import sales.sysconp.microservice.features.address.application.dto.AddressUpdateRequestDTO;
import sales.sysconp.microservice.features.address.application.ports.in.AddressServiceInPort;

import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService implements AddressServiceInPort {

    @Override
    public AddressResponseDTO createAddress(AddressCreateRequestDTO addressCreateRequestDTO) {
        return null;
    }

    @Override
    public AddressResponseDTO updateAddress(Long id, AddressUpdateRequestDTO addressUpdateRequestDTO) {
        return null;
    }

    @Override
    public Optional<AddressResponseDTO> getAddressById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<AddressResponseDTO> getAddressByUUID(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Optional<AddressResponseDTO> getAddressByClientId(Long clientId) {
        return Optional.empty();
    }

    @Override
    public void deleteAddress(Long id) {

    }
}
