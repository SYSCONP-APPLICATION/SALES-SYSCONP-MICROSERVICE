package sales.sysconp.microservice.modules.project.property.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.property.application.services.PropertyService;

@RestController
@RequestMapping("property")
public class DeleteController {
    private final PropertyService propertyService;

    public DeleteController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteProperty(
            @PathVariable("id") Long id
    ) {
        propertyService.deleteProperty(id);
    }
}