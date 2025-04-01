package sales.sysconp.microservice.modules.project.building.domain.models;

import sales.sysconp.microservice.modules.project.project.infrastructure.entities.ProjectEntity;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;
import sales.sysconp.microservice.modules.project.zone.infrastructure.entities.ZoneEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BuildingModel {
    private Long id;
    private UUID uuid;
    private String name;
    private String description;
    private List<PropertyEntity> properties;
    private ZoneEntity zone;
    private ProjectEntity project;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BuildingModel() {}

    public BuildingModel(Long id, UUID uuid, String name, String description, List<PropertyEntity> properties, ZoneEntity zone, ProjectEntity project, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.properties = properties;
        this.zone = zone;
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

    public List<PropertyEntity> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyEntity> properties) {
        this.properties = properties;
    }

    public ZoneEntity getZone() {
        return zone;
    }

    public void setZone(ZoneEntity zone) {
        this.zone = zone;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
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
