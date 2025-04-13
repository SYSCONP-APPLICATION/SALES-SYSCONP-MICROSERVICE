package sales.sysconp.microservice.features.contact_type.application.ports.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import sales.sysconp.microservice.features.contact_type.domain.models.ContactTypeModel;

public interface ContactTypeRepositoryOutPort {
    List<ContactTypeModel> findAll();

    Optional<ContactTypeModel> findById(Long id);

    Optional<ContactTypeModel> findByUUID(UUID uuid);

    ContactTypeModel save(ContactTypeModel contactTypeModel);

    void deleteById(Long id);
}