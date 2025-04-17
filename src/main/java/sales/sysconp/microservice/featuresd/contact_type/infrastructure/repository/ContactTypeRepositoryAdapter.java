package sales.sysconp.microservice.featuresd.contact_type.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.features.contact_type.application.ports.out.ContactTypeRepositoryOutPort;
import sales.sysconp.microservice.features.contact_type.domain.mappers.ContactTypeMapper;
import sales.sysconp.microservice.features.contact_type.domain.models.ContactTypeModel;
import sales.sysconp.microservice.features.contact_type.infrastructure.repository.JPAContactTypeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ContactTypeRepositoryAdapter  implements ContactTypeRepositoryOutPort {
    private final sales.sysconp.microservice.features.contact_type.infrastructure.repository.JPAContactTypeRepository jpaRepository;
    private final ContactTypeMapper mapper;

    public ContactTypeRepositoryAdapter(JPAContactTypeRepository jpaRepository, ContactTypeMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ContactTypeModel> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public Optional<ContactTypeModel> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public Optional<ContactTypeModel> findByUuid(UUID uuid) {
        return jpaRepository.findByUuid(uuid).map(mapper::toModel);
    }

    @Override
    public Optional<ContactTypeModel> findByName(String name) {
        return jpaRepository.findByName(name).map(mapper::toModel);
    }

    @Override
    public ContactTypeModel save(ContactTypeModel contactTypeModel) {
        return mapper.toModel(jpaRepository.save(mapper.toEntity(contactTypeModel)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
