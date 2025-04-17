package sales.sysconp.microservice.config.features.contact_type.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeCreateRequestDTO;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeResponseDTO;
import sales.sysconp.microservice.features.contact_type.application.services.ContactTypeService;

@RestController
@RequestMapping("contact/type")
public class ContactTypeCreateController {
    private final ContactTypeService contactTypeService;

    public ContactTypeCreateController(ContactTypeService contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

    @PostMapping("create")
    public ContactTypeResponseDTO createContactType(
            @RequestBody @Valid ContactTypeCreateRequestDTO contactTypeCreateRequestDTO
    ) {
        return this.contactTypeService.createContactType(contactTypeCreateRequestDTO);
    }
}