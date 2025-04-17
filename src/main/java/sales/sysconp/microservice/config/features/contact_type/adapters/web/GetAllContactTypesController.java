package sales.sysconp.microservice.config.features.contact_type.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeResponseDTO;
import sales.sysconp.microservice.features.contact_type.application.services.ContactTypeService;

import java.util.List;

@RestController
@RequestMapping("contact/type")
public class GetAllContactTypesController {
    private final ContactTypeService contactTypeService;

    public GetAllContactTypesController(ContactTypeService contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

    @GetMapping("all")
    public List<ContactTypeResponseDTO> getAllContactTypes() {
        return this.contactTypeService.getAllContactTypes();
    }
}