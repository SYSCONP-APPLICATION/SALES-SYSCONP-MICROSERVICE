package sales.sysconp.microservice.modules.project.property_category.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class PropertyCategoryUpdateRequestDTO {
    @NotBlank(message = "O nome da categoria eh obrigatorio")
    private String name;

    @NotNull(message = "A data de actualizacao eh obrigatorio")
    private LocalDateTime updatedAt;

    public String getName() {
        return name;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
