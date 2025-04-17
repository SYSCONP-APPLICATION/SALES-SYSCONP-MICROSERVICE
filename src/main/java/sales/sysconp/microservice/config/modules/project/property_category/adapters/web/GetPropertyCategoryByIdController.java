package sales.sysconp.microservice.config.modules.project.property_category.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryResponseDTO;
import sales.sysconp.microservice.modules.project.property_category.application.services.PropertyCategoryService;

@RestController
@RequestMapping("property-category")
public class GetPropertyCategoryByIdController {
    private final PropertyCategoryService propertyCategoryService;

    public GetPropertyCategoryByIdController(PropertyCategoryService propertyCategoryService) {
        this.propertyCategoryService = propertyCategoryService;
    }

    @GetMapping("get/{id}")
    public PropertyCategoryResponseDTO getPropertyCategoryById(
            @PathVariable("id") Long id
    ) {
        return this.propertyCategoryService.getPropertyCategoryById(id);
    }
}
