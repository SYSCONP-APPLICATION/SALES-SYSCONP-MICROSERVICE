package sales.sysconp.microservice.config.modules.project.property_category.adapters.web;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryCreateRequestDTO;
import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryResponseDTO;
import sales.sysconp.microservice.modules.project.property_category.application.services.PropertyCategoryService;

@RestController
@RequestMapping("property-category")
public class CreatePropertyCategoryController {
    private final PropertyCategoryService propertyCategoryService;

    public CreatePropertyCategoryController(PropertyCategoryService propertyCategoryService) {
        this.propertyCategoryService = propertyCategoryService;
    }

    @PostMapping("create")
    public PropertyCategoryResponseDTO createPropertyCategory(
            @RequestBody @Valid PropertyCategoryCreateRequestDTO propertyCategoryCreateRequestDTO
    ) {
        return propertyCategoryService.createPropertyCategory(propertyCategoryCreateRequestDTO);
    }
}