package sales.sysconp.microservice.config.features.address.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.features.address.application.ports.out.AddressRepositoryOutPort;
import sales.sysconp.microservice.features.address.domain.mappers.AddressMapper;
import sales.sysconp.microservice.features.address.domain.models.AddressModel;
import sales.sysconp.microservice.features.address.infrastructure.repository.JPAAddressRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class AddressRepositoryAdapter implements AddressRepositoryOutPort {
    private final sales.sysconp.microservice.features.address.infrastructure.repository.JPAAddressRepository jpaRepository;
    private final AddressMapper addressMapper;

    public AddressRepositoryAdapter(JPAAddressRepository jpaRepository, AddressMapper addressMapper) {
        this.jpaRepository = jpaRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public Optional<AddressModel> findById(Long id) {
        return jpaRepository.findById(id)
                .map(addressMapper::toModel);
    }

    @Override
    public Optional<AddressModel> findByUUID(UUID uuid) {
        return jpaRepository.findByUuid(uuid)
                .map(addressMapper::toModel);
    }

    @Override
    public List<AddressModel> findByClientId(Long clientId) {
        return jpaRepository.findByClientId(clientId)
                .stream()
                .map(addressMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public AddressModel save(AddressModel addressModel) {
        var entity = addressMapper.toEntity(addressModel);
        var savedEntity = jpaRepository.save(entity);
        return addressMapper.toModel(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}