package sales.sysconp.microservice.modules.project.unity.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public class UnityCreateRequestDTO {
    @NotNull(message = "Id cannot be null")
    private Long id;

    @NotNull(message = "Uuid cannot be null")
    private UUID uuid;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "PropertyId cannot be null")
    private Long propertyId;

    @NotNull(message = "CreatedAt cannot be null")
    private LocalDateTime createdAt;

    @NotNull(message = "UpdatedAt cannot be null")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}