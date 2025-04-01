package sales.sysconp.microservice.modules.project.project.domain.models;

import jakarta.persistence.*;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import sales.sysconp.microservice.modules.project.building.infrastructure.entities.BuildingEntity;
import sales.sysconp.microservice.modules.project.project.domain.enums.ProjectStatusEnum;
import sales.sysconp.microservice.modules.project.zone.infrastructure.entities.ZoneEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ProjectModel {
    private Long id;
    private UUID uuid;
    private String name;
    private String description;
    private ProjectStatusEnum status;
    private String location;
    private List<ZoneEntity> zones;
    private List<BuildingEntity> buildings;
    private CompanyEntity company;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProjectModel() {}

    public ProjectModel(Long id, UUID uuid, String name, String description, ProjectStatusEnum status, String location, List<ZoneEntity> zones, List<BuildingEntity> buildings, CompanyEntity company, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.status = status;
        this.location = location;
        this.zones = zones;
        this.buildings = buildings;
        this.company = company;
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

    public ProjectStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ProjectStatusEnum status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<ZoneEntity> getZones() {
        return zones;
    }

    public void setZones(List<ZoneEntity> zones) {
        this.zones = zones;
    }

    public List<BuildingEntity> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingEntity> buildings) {
        this.buildings = buildings;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
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
