package sales.sysconp.microservice.modules.project.property.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.property.application.dto.PropertyResponseDTO;
import sales.sysconp.microservice.modules.project.property.application.services.PropertyService;

import java.util.List;

@RestController
@RequestMapping("property")
public class GetProprietiesByProjectIdController {
    private final PropertyService propertyService;

    public GetProprietiesByProjectIdController (PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("project/{id}/all")
    public List<PropertyResponseDTO> getAllPropertiesByProjectId(
            @PathVariable("id") Long id
    ) {
        return propertyService.getAllPropertiesByProjectId(id);
    }
}
