package sales.sysconp.microservice.modules.project.project.domain.models;

import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.project.building.domain.models.BuildingModel;
import sales.sysconp.microservice.modules.project.project.domain.enums.ProjectStatusEnum;
import sales.sysconp.microservice.modules.project.zone.domain.models.ZoneModel;

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
    private List<ZoneModel> zones;
    private List<BuildingModel> buildings;
    private CompanyModel company;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProjectModel() {}

    public ProjectModel(Long id, UUID uuid, String name, String description, ProjectStatusEnum status, String location, List<ZoneModel> zones, List<BuildingModel> buildings, CompanyModel company, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    public List<ZoneModel> getZones() {
        return zones;
    }

    public void setZones(List<ZoneModel> zones) {
        this.zones = zones;
    }

    public List<BuildingModel> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingModel> buildings) {
        this.buildings = buildings;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
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
