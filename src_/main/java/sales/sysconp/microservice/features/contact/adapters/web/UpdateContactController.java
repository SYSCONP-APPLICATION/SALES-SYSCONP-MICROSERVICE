package sales.sysconp.microservice.features.contact.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.contact.application.dto.ContactResponseDTO;
import sales.sysconp.microservice.features.contact.application.dto.ContactUpdateRequestDTO;
import sales.sysconp.microservice.features.contact.application.services.ContactService;

@RestController
@RequestMapping("contact")
public class UpdateContactController {
    private final ContactService contactService;

    public UpdateContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PutMapping("update/{id}")
    public ContactResponseDTO updateContact(
            @PathVariable("id") Long id,
            @RequestBody @Valid ContactUpdateRequestDTO contactUpdateRequestDTO
    ) {
        return contactService.updateContact(id, contactUpdateRequestDTO);
    }
}
