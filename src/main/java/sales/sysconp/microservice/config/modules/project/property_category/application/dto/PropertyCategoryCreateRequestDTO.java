package sales.sysconp.microservice.config.modules.project.property_category.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.UUID;

public class PropertyCategoryCreateRequestDTO {
    @NotNull(message = "O ID é obrigatório")
    private Long id;

    @NotNull(message = "O UUID é obrigatório")
    private UUID uuid;

    @NotBlank(message = "O nome da categoria é obrigatório")
    private String name;

    @NotNull(message = "O ID da empresa é obrigatório")
    private Long companyId;

    @PastOrPresent(message = "A data de criação não pode ser no futuro")
    private LocalDateTime createdAt;

    @NotNull(message = "A data de atualização é obrigatória")
    @PastOrPresent(message = "A data de atualização não pode ser no futuro")
    private LocalDateTime updatedAt;

    public PropertyCategoryCreateRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
