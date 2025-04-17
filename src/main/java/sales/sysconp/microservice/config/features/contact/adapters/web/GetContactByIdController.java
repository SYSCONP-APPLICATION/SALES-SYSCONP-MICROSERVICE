package sales.sysconp.microservice.config.features.contact.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.contact.application.dto.ContactResponseDTO;
import sales.sysconp.microservice.features.contact.application.services.ContactService;

@RestController
@RequestMapping("contact")
public class GetContactByIdController {
    private final ContactService contactService;

    public GetContactByIdController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("get/{id}")
    public ContactResponseDTO getContactById(
            @PathVariable("id") Long id
    ) {
        return this.contactService.getContactById(id);
    }
}
