package sales.sysconp.microservice.modules.project.property.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.project.property.application.dto.PropertyResponseDTO;
import sales.sysconp.microservice.modules.project.property.application.dto.PropertyUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.property.application.services.PropertyService;

@RestController
@RequestMapping("property")
public class UpdatePropertyController {
    private final PropertyService propertyService;

    public UpdatePropertyController (PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PutMapping("update/{id}")
    public PropertyResponseDTO updateProperty(
            @PathVariable("id") Long id,
            @RequestBody @Valid PropertyUpdateRequestDTO propertyUpdateRequestDTO
    ) {
        return propertyService.updateProperty(id, propertyUpdateRequestDTO);
    }
}