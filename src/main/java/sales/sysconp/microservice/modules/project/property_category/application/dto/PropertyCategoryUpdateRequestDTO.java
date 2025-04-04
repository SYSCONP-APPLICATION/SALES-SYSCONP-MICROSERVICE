package sales.sysconp.microservice.modules.project.property_category.application.dto;

import jakarta.validation.constraints.NotBlank;

public class PropertyCategoryUpdateRequestDTO {
    @NotBlank(message = "O nome da categoria   obrigat rio")
    private String name;
}
