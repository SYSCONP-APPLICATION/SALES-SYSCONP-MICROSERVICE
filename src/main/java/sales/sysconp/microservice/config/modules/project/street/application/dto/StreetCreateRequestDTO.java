package sales.sysconp.microservice.config.modules.project.street.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public class StreetCreateRequestDTO {
    @NotNull(message = "Id is required")
    private Long id;

    @NotNull(message = "UUID is required")
    private UUID uuid;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Project ID is required")
    private Long projectId;

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

    public Long getProjectId() {
        return projectId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}