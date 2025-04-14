package sales.sysconp.microservice.modules.project.property.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyTypeEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class PropertyCreateRequestDTO {
    @NotNull(message = "ID is required")
    private Long id;

    @NotNull(message = "UUID is required")
    private UUID uuid;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Property type is required")
    private PropertyTypeEnum type;

    @NotNull(message = "Project ID is required")
    private Long projectId;

    private Long collectionId;

    @NotNull(message = "Street ID is required")
    private Long streetId;

    private Long clientId;

    private Long propertyCategoryId;

    @NotNull(message = "Creation date is required")
    private LocalDateTime createdAt;

    @NotNull(message = "Update date is required")
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

    public String getDescription() {
        return description;
    }

    public PropertyTypeEnum getType() {
        return type;
    }

    public Long getProjectId() {
        return projectId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public Long getStreetId() {
        return streetId;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getPropertyCategoryId() {
        return propertyCategoryId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
