package sales.sysconp.microservice.config.modules.project.street.application.dto;

import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class StreetResponseDTO {
    private Long id;
    private UUID uuid;
    private String name;
    private ProjectModel project;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StreetResponseDTO() {}

    public StreetResponseDTO(Long id, UUID uuid, String name, ProjectModel project, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.project = project;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectModel getProject() {
        return project;
    }

    public void setProject(ProjectModel project) {
        this.project = project;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}