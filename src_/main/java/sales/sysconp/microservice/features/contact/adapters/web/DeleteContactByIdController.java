package sales.sysconp.microservice.features.contact.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.contact.application.services.ContactService;

@RestController
@RequestMapping("contact")
public class DeleteContactByIdController {
    private final ContactService contactService;

    public DeleteContactByIdController(ContactService contactService) {
        this.contactService = contactService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteContactById(
            @PathVariable("id") Long id
    ) {
        contactService.deleteContact(id);
    }
}
