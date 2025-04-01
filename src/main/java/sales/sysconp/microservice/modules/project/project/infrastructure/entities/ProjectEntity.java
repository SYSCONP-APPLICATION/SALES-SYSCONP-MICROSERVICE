package sales.sysconp.microservice.modules.project.project.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import sales.sysconp.microservice.modules.project.building.infrastructure.entities.BuildingEntity;
import sales.sysconp.microservice.modules.project.project.domain.enums.ProjectStatusEnum;
import sales.sysconp.microservice.modules.project.zone.infrastructure.entities.ZoneEntity;

@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(unique = false, nullable = false)
    private String name;

    @Column(unique = false, nullable = true)
    private String description;

    @Column(unique = false, nullable = false)
    private ProjectStatusEnum status;

    @Column(unique = false, nullable = false)
    private String location;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ZoneEntity> zones;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<BuildingEntity> buildings;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity company;

    @Column(updatable = false)  
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    private LocalDateTime updatedAt;

    @Column(updatable = true)
    private LocalDateTime deletedAt;

    public ProjectEntity() {}

    public ProjectEntity(Long id, UUID uuid, String name, String description, ProjectStatusEnum status, String location, List<ZoneEntity> zones, List<BuildingEntity> buildings, CompanyEntity company, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
