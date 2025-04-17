package sales.sysconp.microservice.config.modules.project.property.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.property.application.dto.PropertyResponseDTO;
import sales.sysconp.microservice.modules.project.property.application.services.PropertyService;

import java.util.UUID;

@RestController
@RequestMapping("property")
public class GetProprietyByUUIDController {
    private final PropertyService propertyService;

    public GetProprietyByUUIDController (PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("uuid/{uuid}")
    public PropertyResponseDTO getPropertyByUUID(
            @PathVariable("uuid") UUID uuid
    ) {
        return propertyService.getPropertyByUUID(uuid);
    }
}