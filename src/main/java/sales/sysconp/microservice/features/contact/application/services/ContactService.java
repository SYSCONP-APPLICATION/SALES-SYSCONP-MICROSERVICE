package sales.sysconp.microservice.features.contact.application.services;

import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.features.client.infrastructure.repository.ClientRepositoryAdapter;
import sales.sysconp.microservice.features.contact.application.dto.ContactCreateRequestDTO;
import sales.sysconp.microservice.features.contact.application.dto.ContactResponseDTO;
import sales.sysconp.microservice.features.contact.application.dto.ContactUpdateRequestDTO;
import sales.sysconp.microservice.features.contact.application.ports.in.ContactServiceInPort;
import sales.sysconp.microservice.features.contact.domain.mappers.ContactMapper;
import sales.sysconp.microservice.features.contact.domain.models.ContactModel;
import sales.sysconp.microservice.features.contact.infrastructure.repository.ContactRepositoryAdapter;
import sales.sysconp.microservice.features.contact_type.domain.models.ContactTypeModel;
import sales.sysconp.microservice.features.contact_type.infrastructure.repository.ContactTypeRepositoryAdapter;
import sales.sysconp.microservice.modules.auth.company.infrastructure.repository.CompanyRepositoryAdapter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ContactService implements ContactServiceInPort {
    private final ContactTypeRepositoryAdapter contactTypeRepositoryAdapter;
    private final ContactRepositoryAdapter contactRepositoryAdapter;
    private final CompanyRepositoryAdapter companyRepositoryAdapter;
    private final ClientRepositoryAdapter clientRepositoryAdapter;
    private final ContactMapper contactMapper;

    public ContactService(
            ContactRepositoryAdapter contactRepositoryAdapter,
            ContactTypeRepositoryAdapter contactTypeRepositoryAdapter,
            CompanyRepositoryAdapter companyRepositoryAdapter,
            ClientRepositoryAdapter clientRepositoryAdapter,
            ContactMapper contactMapper
    ) {
        this.contactTypeRepositoryAdapter = contactTypeRepositoryAdapter;
        this.contactRepositoryAdapter = contactRepositoryAdapter;
        this.companyRepositoryAdapter = companyRepositoryAdapter;
        this.clientRepositoryAdapter = clientRepositoryAdapter;
        this.contactMapper = contactMapper;
    }

    @Override
    public ContactResponseDTO createContact(ContactCreateRequestDTO contactCreateRequestDTO) {
        ClientModel clientModel = clientRepositoryAdapter
                .findById(contactCreateRequestDTO.getClientId())
                .orElseThrow(() -> new NoSuchElementException("Client not found with id: " + contactCreateRequestDTO.getClientId()));

        ContactTypeModel contactTypeModel = contactTypeRepositoryAdapter
                .findById(contactCreateRequestDTO.getContactTypeId())
                .orElseThrow(() -> new NoSuchElementException("ContactType not found with id: " + contactCreateRequestDTO.getContactTypeId()));

        if (contactRepositoryAdapter.findByValueAndClientIdAndContactTypeId(contactCreateRequestDTO.getValue(), contactCreateRequestDTO.getClientId(), contactCreateRequestDTO.getContactTypeId()).isPresent()) {
            throw new IllegalArgumentException("Client already has contact with value: " + contactCreateRequestDTO.getValue());
        }

        ContactModel contactModel = new ContactModel();

        contactModel.setValue(contactCreateRequestDTO.getValue());
        contactModel.setIsPrimary(contactCreateRequestDTO.getIsPrimary());
        contactModel.setContactType(contactTypeModel);
        contactModel.setClient(clientModel);

        return contactMapper.toResponseDTO(contactRepositoryAdapter.save(contactModel));
    }

    @Override
    public ContactResponseDTO updateContact(Long id, ContactUpdateRequestDTO contactUpdateRequestDTO) {
        ContactModel contactModel = contactRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Contact not found with id: " + id));

        if (contactRepositoryAdapter.findByValueAndClientIdAndContactTypeId(contactUpdateRequestDTO.getValue(), contactModel.getClient().getId(), contactUpdateRequestDTO.getContactTypeId()).isPresent() && !contactModel.getId().equals(id)) {
            throw new IllegalArgumentException("Someone is already using this contact value: " + contactUpdateRequestDTO.getValue());
        }

        if (contactUpdateRequestDTO.getValue() != null) {
            contactModel.setValue(contactUpdateRequestDTO.getValue());
        }

        if (contactUpdateRequestDTO.getIsPrimary() != null) {
            contactModel.setIsPrimary(contactUpdateRequestDTO.getIsPrimary());
        }

        if (contactUpdateRequestDTO.getContactTypeId() != null) {
            ContactTypeModel contactTypeModel = contactTypeRepositoryAdapter
                    .findById(contactUpdateRequestDTO.getContactTypeId())
                    .orElseThrow(() -> new NoSuchElementException("ContactType not found with id: " + contactUpdateRequestDTO.getContactTypeId()));

            contactModel.setContactType(contactTypeModel);
        }

        return contactMapper.toResponseDTO(contactRepositoryAdapter.save(contactModel));
    }

    @Override
    public ContactResponseDTO getContactById(Long id) {
        return contactRepositoryAdapter.findById(id)
                .map(contactMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Contact not found with UUID: " + id));
    }
    @Override
    public List<ContactResponseDTO> getContactsByClientId(Long clientId) {
        return contactRepositoryAdapter.findAllByClientId(clientId).stream()
                .map(contactMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ContactResponseDTO getContactByUUID(UUID uuid) {
        return contactRepositoryAdapter.findByUUID(uuid)
                .map(contactMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Contact not found with UUID: " + uuid));
    }

    @Override
    public List<ContactResponseDTO> findAllContactsByClientId(Long clientId) {
        this.clientRepositoryAdapter.findById(clientId)
                .orElseThrow(() -> new NoSuchElementException("Client not found with id: " + clientId));

        return contactRepositoryAdapter.findAllByClientId(clientId).stream()
                .map(contactMapper::toResponseDTO)
                .toList();
    }
    @Override
    public List<ContactResponseDTO> getAllContactsByCompanyId(Long companyId) {
        this.companyRepositoryAdapter
                .findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company not found with id: " + companyId));

        return contactRepositoryAdapter.findAllByCompanyId(companyId).stream()
                .map(contactMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void deleteContact(Long id) {
        this.contactRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Contact not found with id: " + id));

        this.contactRepositoryAdapter.deleteById(id);
    }
}
