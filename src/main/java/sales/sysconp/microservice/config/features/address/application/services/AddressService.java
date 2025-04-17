package sales.sysconp.microservice.config.features.address.application.services;

import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.address.application.dto.AddressCreateRequestDTO;
import sales.sysconp.microservice.features.address.application.dto.AddressResponseDTO;
import sales.sysconp.microservice.features.address.application.dto.AddressUpdateRequestDTO;
import sales.sysconp.microservice.features.address.application.ports.in.AddressServiceInPort;
import sales.sysconp.microservice.features.address.domain.mappers.AddressMapper;
import sales.sysconp.microservice.features.address.domain.models.AddressModel;
import sales.sysconp.microservice.features.address.infrastructure.repository.AddressRepositoryAdapter;
import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.features.client.infrastructure.repository.ClientRepositoryAdapter;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService implements AddressServiceInPort {
    private final AddressRepositoryAdapter addressRepositoryAdapter;
    private final ClientRepositoryAdapter clientRepositoryAdapter;
    private final AddressMapper addressMapper;

    public AddressService(AddressRepositoryAdapter addressRepositoryAdapter, AddressMapper addressMapper, ClientRepositoryAdapter clientRepositoryAdapter) {
        this.addressRepositoryAdapter = addressRepositoryAdapter;
        this.clientRepositoryAdapter = clientRepositoryAdapter;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressResponseDTO createAddress(AddressCreateRequestDTO addressCreateRequestDTO) {
        ClientModel clientModel = this.clientRepositoryAdapter.findById(addressCreateRequestDTO.getClientId())
                .orElseThrow(() -> new NoSuchElementException("Client not found with id: " + addressCreateRequestDTO.getClientId()));

        if (clientModel.getAddress() != null) {
            throw new IllegalArgumentException("Client already has an address");
        }

        AddressModel addressModel = new AddressModel();

        addressModel.setStreet(addressCreateRequestDTO.getStreet());
        addressModel.setPostalCode(addressCreateRequestDTO.getPostalCode());
        addressModel.setDescription(addressCreateRequestDTO.getDescription());
        addressModel.setNeighborhood(addressCreateRequestDTO.getNeighborhood());
        addressModel.setMunicipality(addressCreateRequestDTO.getMunicipality());
        addressModel.setProvince(addressCreateRequestDTO.getProvince());
        addressModel.setCountry(addressCreateRequestDTO.getCountry());
        addressModel.setCity(addressCreateRequestDTO.getCity());
        addressModel.setClient(clientModel);

        return addressMapper.toResponseDTO(addressRepositoryAdapter.save(addressModel));
    }

    @Override
    public AddressResponseDTO updateAddress(Long id, AddressUpdateRequestDTO addressUpdateRequestDTO) {
        AddressModel addressModel = addressRepositoryAdapter.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Address not found with id: " + id));

        if (addressUpdateRequestDTO.getStreet() != null) {
            addressModel.setStreet(addressUpdateRequestDTO.getStreet());
        }

        if (addressUpdateRequestDTO.getPostalCode() != null) {
            addressModel.setPostalCode(addressUpdateRequestDTO.getPostalCode());
        }

        if (addressUpdateRequestDTO.getDescription() != null) {
            addressModel.setDescription(addressUpdateRequestDTO.getDescription());
        }

        if (addressUpdateRequestDTO.getNeighborhood() != null) {
            addressModel.setNeighborhood(addressUpdateRequestDTO.getNeighborhood());
        }

        if (addressUpdateRequestDTO.getMunicipality() != null) {
            addressModel.setMunicipality(addressUpdateRequestDTO.getMunicipality());
        }

        if (addressUpdateRequestDTO.getProvince() != null) {
            addressModel.setProvince(addressUpdateRequestDTO.getProvince());
        }

        if (addressUpdateRequestDTO.getCountry() != null) {
            addressModel.setCountry(addressUpdateRequestDTO.getCountry());
        }

        if (addressUpdateRequestDTO.getCity() != null) {
            addressModel.setCity(addressUpdateRequestDTO.getCity());
        }

        AddressModel updatedAddress = addressRepositoryAdapter.save(addressModel);
        return addressMapper.toResponseDTO(updatedAddress);
    }

    @Override
    public AddressResponseDTO getAddressById(Long id) {
        return addressRepositoryAdapter.findById(id)
                .map(addressMapper::toResponseDTO).orElseThrow(() -> new NoSuchElementException("Address not found with id: " + id));
    }

    @Override
    public AddressResponseDTO getAddressByUUID(UUID uuid) {
        return addressRepositoryAdapter.findByUUID(uuid)
                .map(addressMapper::toResponseDTO).orElseThrow(() -> new NoSuchElementException("Address not found with uuid: " + uuid));
    }

    @Override
    public AddressResponseDTO getAddressByClientId(Long clientId) {
        this.clientRepositoryAdapter
                .findById(clientId)
                .orElseThrow(() -> new NoSuchElementException("Client not found with id: " + clientId));

        return addressRepositoryAdapter.findByClientId(clientId)
                .stream()
                .findFirst()
                .map(addressMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Address not found with client id: " + clientId));
    }

    @Override
    public void deleteAddress(Long id) {
        AddressModel addressModel = this.addressRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Address not found with id: " + id));

        addressModel.setClient(null);
        this.addressRepositoryAdapter.save(addressModel);

        this.addressRepositoryAdapter.deleteById(id);
    }
}
