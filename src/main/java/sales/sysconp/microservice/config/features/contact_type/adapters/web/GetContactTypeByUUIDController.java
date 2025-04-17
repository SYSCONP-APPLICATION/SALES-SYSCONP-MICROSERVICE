package sales.sysconp.microservice.config.features.contact_type.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeResponseDTO;
import sales.sysconp.microservice.features.contact_type.application.services.ContactTypeService;

import java.util.UUID;

@RestController
@RequestMapping("contact/type")
public class GetContactTypeByUUIDController {
    private final ContactTypeService contactTypeService;

    public GetContactTypeByUUIDController(ContactTypeService contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

    @GetMapping("uuid/{uuid}")
    public ContactTypeResponseDTO getContactTypeByUUID(
        @PathVariable("uuid") UUID uuid
    ) {
        return this.contactTypeService.getContactTypeByUUID(uuid);
    }
}