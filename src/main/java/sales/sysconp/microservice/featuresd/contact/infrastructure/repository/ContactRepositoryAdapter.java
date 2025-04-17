package sales.sysconp.microservice.featuresd.contact.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.features.contact.application.ports.out.ContactRepositoryOutPort;
import sales.sysconp.microservice.features.contact.domain.mappers.ContactMapper;
import sales.sysconp.microservice.features.contact.domain.models.ContactModel;
import sales.sysconp.microservice.features.contact.infrastructure.repository.JPAContactRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ContactRepositoryAdapter implements ContactRepositoryOutPort {
    private final sales.sysconp.microservice.features.contact.infrastructure.repository.JPAContactRepository jpaRepository;
    private final ContactMapper mapper;

    public ContactRepositoryAdapter(JPAContactRepository jpaRepository, ContactMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ContactModel> findAllByCompanyId(Long companyId) {
        return jpaRepository.findAllByClient_Company_Id(companyId)
                            .stream()
                            .map(mapper::toModel)
                            .toList();
    }

    @Override
    public Optional<ContactModel> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public Optional<ContactModel> findByUUID(UUID uuid) {
        return jpaRepository.findByUuid(uuid).map(mapper::toModel);
    }

    @Override
    public List<ContactModel> findAllByClientId(Long clientId) {
        return jpaRepository.findAllByClientId(clientId)
                .stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public Optional<ContactModel> findByValueAndClientIdAndContactTypeId(String value, Long clientId, Long contactTypeId) {
        return jpaRepository.findByValueAndClientIdAndContactTypeId(value, clientId, contactTypeId)
                .map(mapper::toModel);
    }

    @Override
    public ContactModel save(ContactModel contactModel) {
        return mapper.toModel(jpaRepository.save(mapper.toEntity(contactModel)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}