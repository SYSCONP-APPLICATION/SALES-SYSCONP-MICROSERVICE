package sales.sysconp.microservice.modules.project.building.infrastructure.entities;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import sales.sysconp.microservice.modules.project.project.infrastructure.entities.ProjectEntity;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;
import sales.sysconp.microservice.modules.project.zone.infrastructure.entities.ZoneEntity;

@Entity
@Table(name = "buildings")
public class BuildingEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(unique = false, nullable = true)
    private String description;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private List<PropertyEntity> properties;

    @ManyToOne
    @JoinColumn(name = "zone_id") 
    private ZoneEntity zone;

    @ManyToOne
    @JoinColumn(name = "project_id") 
    private ProjectEntity project;

    @Column(updatable = false)  
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    private LocalDateTime updatedAt;

    @Column(updatable = true)
    private LocalDateTime deletedAt;

    public BuildingEntity() {}

    public BuildingEntity(Long id, UUID uuid, String name, String description, List<PropertyEntity> properties, ZoneEntity zone, ProjectEntity project, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
