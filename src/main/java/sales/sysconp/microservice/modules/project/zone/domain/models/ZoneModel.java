package sales.sysconp.microservice.modules.project.zone.domain.models;

import sales.sysconp.microservice.modules.project.building.infrastructure.entities.BuildingEntity;
import sales.sysconp.microservice.modules.project.project.infrastructure.entities.ProjectEntity;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ZoneModel {
    private Long id;
    private UUID uuid;
    private String name;
    private String postalCode;
    private ProjectEntity project;
    private List<PropertyEntity> properties;
    private List<BuildingEntity> buildings;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ZoneModel() {
    }

    public ZoneModel(Long id, UUID uuid, String name, String postalCode, ProjectEntity project, List<PropertyEntity> properties, List<BuildingEntity> buildings, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.postalCode = postalCode;
        this.project = project;
        this.properties = properties;
        this.buildings = buildings;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public List<PropertyEntity> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyEntity> properties) {
        this.properties = properties;
    }

    public List<BuildingEntity> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingEntity> buildings) {
        this.buildings = buildings;
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
