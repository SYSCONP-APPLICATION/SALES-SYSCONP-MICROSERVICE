package sales.sysconp.microservice.featuresd.contact_type.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.contact_type.application.services.ContactTypeService;

@RestController
@RequestMapping("contact/type")
public class DeleteContactTypeByIdController {
    private final ContactTypeService contactTypeService;

    public DeleteContactTypeByIdController(ContactTypeService contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteContactTypeById(
            @PathVariable("id") Long id
    ) {
        contactTypeService.deleteContactType(id);
    }
}