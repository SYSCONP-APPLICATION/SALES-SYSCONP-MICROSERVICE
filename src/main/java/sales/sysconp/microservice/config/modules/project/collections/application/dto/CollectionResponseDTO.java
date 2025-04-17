package sales.sysconp.microservice.config.modules.project.collections.application.dto;

import sales.sysconp.microservice.modules.project.collections.domain.enums.CollectionTypeEnum;
import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class CollectionResponseDTO {
    private Long id;
    private UUID uuid;
    private String name;
    private String description;
    private CollectionTypeEnum type;
    private ProjectModel project;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CollectionResponseDTO() {}

    public CollectionResponseDTO(Long id, UUID uuid, String name, String description, CollectionTypeEnum type, ProjectModel project, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CollectionTypeEnum getType() {
        return type;
    }

    public void setType(CollectionTypeEnum type) {
        this.type = type;
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
