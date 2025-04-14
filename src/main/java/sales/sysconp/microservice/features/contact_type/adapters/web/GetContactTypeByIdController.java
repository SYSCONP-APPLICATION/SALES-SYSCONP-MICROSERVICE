package sales.sysconp.microservice.features.contact_type.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeResponseDTO;
import sales.sysconp.microservice.features.contact_type.application.services.ContactTypeService;

@RestController
@RequestMapping("contact/type")
public class GetContactTypeByIdController {
    private final ContactTypeService contactTypeService;

    public GetContactTypeByIdController(ContactTypeService contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

    @GetMapping("get/{id}")
    public ContactTypeResponseDTO createContactType(
        @PathVariable("id") Long id
    ) {
        return this.contactTypeService.getContactTypeById(id);
    }
}