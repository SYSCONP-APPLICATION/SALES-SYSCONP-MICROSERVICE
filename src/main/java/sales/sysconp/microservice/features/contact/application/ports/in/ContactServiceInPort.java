package sales.sysconp.microservice.features.contact.application.ports.in;

import sales.sysconp.microservice.features.contact.application.dto.ContactCreateRequestDTO;
import sales.sysconp.microservice.features.contact.application.dto.ContactResponseDTO;
import sales.sysconp.microservice.features.contact.application.dto.ContactUpdateRequestDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactServiceInPort {
    ContactResponseDTO createContact(ContactCreateRequestDTO contactCreateRequestDTO);

    ContactResponseDTO updateContact(Long id, ContactUpdateRequestDTO contactUpdateRequestDTO);

    ContactResponseDTO getContactById(Long id);

    List<ContactResponseDTO> getContactsByClientId(Long clientId);

    ContactResponseDTO getContactByUUID(UUID uuid);

    List<ContactResponseDTO> findAllContactsByClientId(Long clientId);

    List<ContactResponseDTO> getAllContactsByCompanyId(Long companyId);

    void deleteContact(Long id);
}
