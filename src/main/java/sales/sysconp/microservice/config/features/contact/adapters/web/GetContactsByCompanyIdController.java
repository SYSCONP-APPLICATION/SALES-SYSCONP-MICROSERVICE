package sales.sysconp.microservice.config.features.contact.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.contact.application.dto.ContactResponseDTO;
import sales.sysconp.microservice.features.contact.application.services.ContactService;

import java.util.List;

@RestController
@RequestMapping("contact")
public class GetContactsByCompanyIdController {
    private final ContactService contactService;

    public GetContactsByCompanyIdController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("company/{id}/all")
    public List<ContactResponseDTO> getContactsByCompanyId(
            @PathVariable("id") Long id
    ) {
        return this.contactService.getAllContactsByCompanyId(id);
    }
}