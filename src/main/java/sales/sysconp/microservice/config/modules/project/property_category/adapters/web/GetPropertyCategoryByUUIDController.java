package sales.sysconp.microservice.config.modules.project.property_category.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryResponseDTO;
import sales.sysconp.microservice.modules.project.property_category.application.services.PropertyCategoryService;

import java.util.UUID;

@RestController
@RequestMapping("property-category")
public class GetPropertyCategoryByUUIDController {
    private final PropertyCategoryService propertyCategoryService;

    public GetPropertyCategoryByUUIDController (PropertyCategoryService propertyCategoryService) {
        this.propertyCategoryService = propertyCategoryService;
    }

    @GetMapping("uuid/{uuid}")
    public PropertyCategoryResponseDTO getPropertyCategoryByUUID(
            @PathVariable("uuid") UUID uuid
    ) {
        return this.propertyCategoryService.getPropertyCategoryByUUID(uuid);
    }
}
