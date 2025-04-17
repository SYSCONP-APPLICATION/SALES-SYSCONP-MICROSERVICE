package sales.sysconp.microservice.config.modules.project.property.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.property.application.dto.PropertyCreateRequestDTO;
import sales.sysconp.microservice.modules.project.property.application.dto.PropertyResponseDTO;
import sales.sysconp.microservice.modules.project.property.application.services.PropertyService;

@RestController
@RequestMapping("property")
public class CreatePropertyController {
    private final PropertyService propertyService;

    public CreatePropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("create")
    public PropertyResponseDTO createProperty(
            @RequestBody @Valid PropertyCreateRequestDTO propertyCreateRequestDTO
    ) {
        return propertyService.createProperty(propertyCreateRequestDTO);
    }
}