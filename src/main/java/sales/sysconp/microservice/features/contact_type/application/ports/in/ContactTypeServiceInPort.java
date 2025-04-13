package sales.sysconp.microservice.features.contact_type.application.ports.in;

import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeCreateRequestDTO;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeResponseDTO;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeUpdateRequestDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactTypeServiceInPort {
    ContactTypeResponseDTO createContactType(ContactTypeCreateRequestDTO contactTypeCreateRequestDTO);

    ContactTypeResponseDTO updateContactType(Long id, ContactTypeUpdateRequestDTO contactTypeUpdateRequestDTO);

    Optional<ContactTypeResponseDTO> getContactTypeById(Long id);

    Optional<ContactTypeResponseDTO> getContactTypeByUUID(UUID uuid);

    List<ContactTypeResponseDTO> getAllContactTypes();

    void deleteContactType(Long id);
}