package sales.sysconp.microservice.modules.project.building.domain.models;

import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;
import sales.sysconp.microservice.modules.project.property.domain.models.PropertyModel;
import sales.sysconp.microservice.modules.project.zone.domain.models.ZoneModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BuildingModel {
    private Long id;
    private UUID uuid;
    private String name;
    private String description;
    private List<PropertyModel> properties;
    private ZoneModel zone;
    private ProjectModel project;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public BuildingModel() {}

    public BuildingModel(Long id, UUID uuid, String name, String description, List<PropertyModel> properties, ZoneModel zone, ProjectModel project, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.properties = properties;
        this.zone = zone;
        this.project = project;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
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

    public List<PropertyModel> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyModel> properties) {
        this.properties = properties;
    }

    public ZoneModel getZone() {
        return zone;
    }

    public void setZone(ZoneModel zone) {
        this.zone = zone;
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


    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
