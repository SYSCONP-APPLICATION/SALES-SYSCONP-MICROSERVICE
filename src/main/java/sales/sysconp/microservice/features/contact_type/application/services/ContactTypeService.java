package sales.sysconp.microservice.features.contact_type.application.services;

import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeCreateRequestDTO;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeResponseDTO;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeUpdateRequestDTO;
import sales.sysconp.microservice.features.contact_type.application.ports.in.ContactTypeServiceInPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactTypeService implements ContactTypeServiceInPort {

    @Override
    public ContactTypeResponseDTO createContactType(ContactTypeCreateRequestDTO contactTypeCreateRequestDTO) {
        return null;
    }

    @Override
    public ContactTypeResponseDTO updateContactType(Long id, ContactTypeUpdateRequestDTO contactTypeUpdateRequestDTO) {
        return null;
    }

    @Override
    public Optional<ContactTypeResponseDTO> getContactTypeById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ContactTypeResponseDTO> getContactTypeByUUID(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<ContactTypeResponseDTO> getAllContactTypes() {
        return List.of();
    }

    @Override
    public void deleteContactType(Long id) {

    }
}
