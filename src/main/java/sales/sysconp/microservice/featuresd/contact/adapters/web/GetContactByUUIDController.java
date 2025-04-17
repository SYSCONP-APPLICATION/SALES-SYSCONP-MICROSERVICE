package sales.sysconp.microservice.featuresd.contact.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.contact.application.dto.ContactResponseDTO;
import sales.sysconp.microservice.features.contact.application.services.ContactService;

import java.util.UUID;

@RestController
@RequestMapping("contact")
public class GetContactByUUIDController {
    private final ContactService contactService;

    public GetContactByUUIDController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("uuid/{uuid}")
    public ContactResponseDTO getContactByUUID(
            @PathVariable("uuid") UUID uuid
    ) {
        return this.contactService.getContactByUUID(uuid);
    }
}
