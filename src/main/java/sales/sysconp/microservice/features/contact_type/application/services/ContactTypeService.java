package sales.sysconp.microservice.features.contact_type.application.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeCreateRequestDTO;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeResponseDTO;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeUpdateRequestDTO;
import sales.sysconp.microservice.features.contact_type.application.ports.in.ContactTypeServiceInPort;
import sales.sysconp.microservice.features.contact_type.domain.mappers.ContactTypeMapper;
import sales.sysconp.microservice.features.contact_type.domain.models.ContactTypeModel;
import sales.sysconp.microservice.features.contact_type.infrastructure.repository.ContactTypeRepositoryAdapter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactTypeService implements ContactTypeServiceInPort {
    private final ContactTypeRepositoryAdapter contactTypeRepositoryAdapter;
    private final ContactTypeMapper contactTypeMapper;

    @Override
    public ContactTypeResponseDTO createContactType(ContactTypeCreateRequestDTO contactTypeCreateRequestDTO) {
        this.contactTypeRepositoryAdapter
                .findByName(contactTypeCreateRequestDTO.getName())
                .orElseThrow(() -> new NoSuchElementException("ContactType already exists"));

        ContactTypeModel contactType = new ContactTypeModel();
        contactType.setName(contactTypeCreateRequestDTO.getName());
        ContactTypeModel savedContactTypeModel = this.contactTypeRepositoryAdapter.save(contactType);

        return contactTypeMapper.toResponseDTO(savedContactTypeModel);
    }

    @Override
    public ContactTypeResponseDTO updateContactType(Long id, ContactTypeUpdateRequestDTO contactTypeUpdateRequestDTO) {
        ContactTypeModel contactType = this.contactTypeRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("ContactType not found with id: " + id + " already!"));

        Optional<ContactTypeModel> contactTypeModelByName = this.contactTypeRepositoryAdapter
                .findByName(contactTypeUpdateRequestDTO.getName());

        if (contactTypeModelByName.isPresent() && !contactTypeModelByName.get().getId().equals(id)) {
            throw new IllegalArgumentException("ContactType with name " + contactTypeUpdateRequestDTO.getName() + " already exists");
        }

        contactType.setName(contactTypeUpdateRequestDTO.getName());
        return contactTypeMapper.toResponseDTO(this.contactTypeRepositoryAdapter.save(contactType));
    }

    @Override
    public ContactTypeResponseDTO getContactTypeById(Long id) {
        return this.contactTypeRepositoryAdapter.findById(id)
                .map(contactTypeMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("ContactType not found with id: " + id));
    }

    @Override
    public ContactTypeResponseDTO getContactTypeByUUID(UUID uuid) {
        return this.contactTypeRepositoryAdapter.findByUuid(uuid)
                .map(contactTypeMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("ContactType not found with id: " + uuid));
    }

    @Override
    public List<ContactTypeResponseDTO> getAllContactTypes() {
        return this.contactTypeRepositoryAdapter.findAll()
                .stream()
                .map(contactTypeMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void deleteContactType(Long id) {
        this.contactTypeRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("ContactType not found with id: " + id + " already!"));

        this.contactTypeRepositoryAdapter.deleteById(id);
    }
}