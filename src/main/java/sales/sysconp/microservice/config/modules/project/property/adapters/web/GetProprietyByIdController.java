package sales.sysconp.microservice.config.modules.project.property.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.property.application.dto.PropertyResponseDTO;
import sales.sysconp.microservice.modules.project.property.application.services.PropertyService;

@RestController
@RequestMapping("property")
public class GetProprietyByIdController {
    private final PropertyService propertyService;

    public GetProprietyByIdController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("get/{id}")
    public PropertyResponseDTO getPropertyById(
            @PathVariable("id") Long id
    ) {
        return propertyService.getPropertyById(id);
    }
}
