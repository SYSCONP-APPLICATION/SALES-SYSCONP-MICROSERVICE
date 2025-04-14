package sales.sysconp.microservice.modules.project.property_category.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.project.property_category.application.services.PropertyCategoryService;

@RestController
@RequestMapping("property-category")
public class DeletePropertyCategoryController {
    private final PropertyCategoryService propertyCategoryService;

    public DeletePropertyCategoryController (PropertyCategoryService propertyCategoryService) {
        this.propertyCategoryService = propertyCategoryService;
    }

    @DeleteMapping("delete/{id}")
    public void updatePropertyCategory(
            @PathVariable Long id
    ) {
        propertyCategoryService.deletePropertyCategory(id);
    }
}
