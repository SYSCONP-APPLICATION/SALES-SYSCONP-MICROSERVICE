package sales.sysconp.microservice.features.contact.application.ports.out;

import sales.sysconp.microservice.features.contact.domain.models.ContactModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactRepositoryOutPort {
    List<ContactModel> findAllByCompanyId(Long companyId);

    Optional<ContactModel> findById(Long id);

    Optional<ContactModel> findByUUID(UUID uuid);

    ContactModel save(ContactModel contactModel);

    void deleteById(Long id);
}