package sales.sysconp.microservice.modules.project.property_category.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryResponseDTO;
import sales.sysconp.microservice.modules.project.property_category.application.services.PropertyCategoryService;

import java.util.List;

@RestController
@RequestMapping("property-category")
public class GetAllCompanyPropertyCategoriesController {
    private final PropertyCategoryService propertyCategoryService;

    public GetAllCompanyPropertyCategoriesController(PropertyCategoryService propertyCategoryService) {
        this.propertyCategoryService = propertyCategoryService;
    }

    @GetMapping("company/{companyId}/all")
    public List<PropertyCategoryResponseDTO> getAllCompanyPropertyCategories(
            @PathVariable Long companyId
    ) {
        return propertyCategoryService.getAllCompanyPropertyCategories(companyId);
    }
}
