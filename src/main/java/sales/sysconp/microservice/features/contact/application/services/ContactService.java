package sales.sysconp.microservice.features.contact.application.services;

import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.contact.application.dto.ContactCreateRequestDTO;
import sales.sysconp.microservice.features.contact.application.dto.ContactResponseDTO;
import sales.sysconp.microservice.features.contact.application.dto.ContactUpdateRequestDTO;
import sales.sysconp.microservice.features.contact.application.ports.in.ContactServiceInPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactService implements ContactServiceInPort {

    @Override
    public ContactResponseDTO createContact(ContactCreateRequestDTO contactCreateRequestDTO) {
        return null;
    }

    @Override
    public ContactResponseDTO updateContact(Long id, ContactUpdateRequestDTO contactUpdateRequestDTO) {
        return null;
    }

    @Override
    public Optional<ContactResponseDTO> getContactById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ContactResponseDTO> getContactByUUID(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<ContactResponseDTO> getAllContactsByCompanyId(Long companyId) {
        return List.of();
    }

    @Override
    public void deleteContact(Long id) {

    }
}
