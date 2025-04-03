package sales.sysconp.microservice.modules.project.project.infrastructure.entities;

import jakarta.persistence.*;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import sales.sysconp.microservice.modules.project.collections.infrastructure.entities.CollectionEntity;
import sales.sysconp.microservice.modules.project.project.domain.enums.ProjectStatusEnum;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;
import sales.sysconp.microservice.modules.project.street.infrastructure.entities.StreetEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private ProjectStatusEnum status;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = true)
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<StreetEntity> streets;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<PropertyEntity> properties;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<CollectionEntity> collections;

    @ManyToOne()
    @JoinColumn(name = "company_id", nullable = false, referencedColumnName = "id")
    private CompanyEntity company;

    @ManyToOne()
    @JoinColumn(name = "street_id", nullable = false, referencedColumnName = "id")
    private StreetEntity street;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = true)
    private LocalDateTime updatedAt;

    @Column(updatable = true)
    private LocalDateTime deletedAt;

    public ProjectEntity() {
    }

    public ProjectEntity(Long id, UUID uuid, String name, String description, ProjectStatusEnum status, LocalDateTime startDate, LocalDateTime endDate, List<StreetEntity> streets, List<PropertyEntity> properties, List<CollectionEntity> collections, CompanyEntity company, StreetEntity street, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.streets = streets;
        this.properties = properties;
        this.collections = collections;
        this.company = company;
        this.street = street;
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<StreetEntity> getStreets() {
        return streets;
    }

    public void setStreets(List<StreetEntity> streets) {
        this.streets = streets;
    }

    public List<PropertyEntity> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyEntity> properties) {
        this.properties = properties;
    }

    public List<CollectionEntity> getCollections() {
        return collections;
    }

    public void setCollections(List<CollectionEntity> collections) {
        this.collections = collections;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public StreetEntity getStreet() {
        return street;
    }

    public void setStreet(StreetEntity street) {
        this.street = street;
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
