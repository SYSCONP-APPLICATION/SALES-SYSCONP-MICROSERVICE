package sales.sysconp.microservice.config.modules.project.property_category.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryResponseDTO;
import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.property_category.application.services.PropertyCategoryService;

@RestController
@RequestMapping("property-category")
public class UpdatePropertyCategoryController {
    private final PropertyCategoryService propertyCategoryService;

    public UpdatePropertyCategoryController(PropertyCategoryService propertyCategoryService) {
        this.propertyCategoryService = propertyCategoryService;
    }

    @PutMapping("update/{id}")
    public PropertyCategoryResponseDTO updatePropertyCategory(
            @PathVariable Long id,
            @RequestBody @Valid PropertyCategoryUpdateRequestDTO propertyCategoryUpdateRequestDTO
    ) {
        return propertyCategoryService.updatePropertyCategory(id, propertyCategoryUpdateRequestDTO);
    }
}
