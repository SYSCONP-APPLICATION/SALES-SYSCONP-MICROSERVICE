package sales.sysconp.microservice.features.contact_type.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeResponseDTO;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeUpdateRequestDTO;
import sales.sysconp.microservice.features.contact_type.application.services.ContactTypeService;

@RestController
@RequestMapping("contact/type")
public class ContactTypeUpdateController {
    private final ContactTypeService contactTypeService;

    public ContactTypeUpdateController(ContactTypeService contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

    @PutMapping("update/{id}")
    public ContactTypeResponseDTO createContactType(
            @PathVariable("id") Long id,
            @RequestBody @Valid ContactTypeUpdateRequestDTO contactTypeCreateRequestDTO
    ) {
        return this.contactTypeService.updateContactType(id, contactTypeCreateRequestDTO);
    }
}