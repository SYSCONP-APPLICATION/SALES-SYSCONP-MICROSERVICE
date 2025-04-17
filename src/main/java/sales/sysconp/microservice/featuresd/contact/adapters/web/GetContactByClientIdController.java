package sales.sysconp.microservice.featuresd.contact.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.contact.application.dto.ContactResponseDTO;
import sales.sysconp.microservice.features.contact.application.services.ContactService;

import java.util.List;

@RestController
@RequestMapping("contact")
public class GetContactByClientIdController {
    private final ContactService contactService;

    public GetContactByClientIdController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("client/{id}/all")
    public List<ContactResponseDTO> getContactsByClientId(
            @PathVariable("id") Long id
    ) {
        return this.contactService.getAllContactsByClientId(id);
    }
}
