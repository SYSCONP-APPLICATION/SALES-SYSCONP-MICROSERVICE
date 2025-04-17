package sales.sysconp.microservice.config.features.contact.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.contact.application.dto.ContactCreateRequestDTO;
import sales.sysconp.microservice.features.contact.application.dto.ContactResponseDTO;
import sales.sysconp.microservice.features.contact.application.services.ContactService;

@RestController
@RequestMapping("contact")
public class CreateContactController {
    private final ContactService contactService;

    public CreateContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("create")
    public ContactResponseDTO createContact(
            @RequestBody @Valid ContactCreateRequestDTO contactCreateRequestDTO
    ) {
        return contactService.createContact(contactCreateRequestDTO);
    }
}
