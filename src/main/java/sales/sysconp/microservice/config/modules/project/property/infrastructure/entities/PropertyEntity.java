package sales.sysconp.microservice.config.modules.project.property.infrastructure.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;
import sales.sysconp.microservice.modules.project.collections.infrastructure.entities.CollectionEntity;
import sales.sysconp.microservice.modules.project.project.infrastructure.entities.ProjectEntity;
import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyStatusEnum;
import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyTypeEnum;
import sales.sysconp.microservice.modules.project.property_category.infrastructure.entities.PropertyCategoryEntity;
import sales.sysconp.microservice.modules.project.street.infrastructure.entities.StreetEntity;
import sales.sysconp.microservice.modules.project.unity.infrastructure.entities.UnityEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "properties")
@SQLDelete(sql = "UPDATE properties SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class PropertyEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private PropertyTypeEnum type;

    @ManyToOne()
    @JoinColumn(name = "project_id", nullable = false, referencedColumnName = "id")
    private ProjectEntity project;

    @ManyToOne()
    @JoinColumn(name = "collection_id", nullable = true, referencedColumnName = "id")
    private CollectionEntity collection;

    @ManyToOne()
    @JoinColumn(name = "property_category_id", nullable = true, referencedColumnName = "id")
    private PropertyCategoryEntity propertyCategory;

    @ManyToOne()
    @JoinColumn(name = "street_id", nullable = false, referencedColumnName = "id")
    private StreetEntity street;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<UnityEntity> unities;

    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = true, referencedColumnName = "id")
    private ClientEntity client;

    @Column(nullable = false)
    private PropertyStatusEnum status;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = true)
    private LocalDateTime updatedAt;

    @Column(updatable = true)
    private LocalDateTime deletedAt;

    public PropertyEntity() {
    }

    public PropertyEntity(Long id, UUID uuid, String name, String description, StreetEntity street, ClientEntity client, PropertyTypeEnum type, ProjectEntity project, CollectionEntity collection, PropertyCategoryEntity propertyCategory, List<UnityEntity> unities, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.type = type;
        this.project = project;
        this.collection = collection;
        this.street = street;
        this.client = client;
        this.propertyCategory = propertyCategory;
        this.unities = unities;
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

    public PropertyTypeEnum getType() {
        return type;
    }

    public void setType(PropertyTypeEnum type) {
        this.type = type;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public CollectionEntity getCollection() {
        return collection;
    }

    public void setCollection(CollectionEntity collection) {
        this.collection = collection;
    }

    public PropertyCategoryEntity getPropertyCategory() {
        return propertyCategory;
    }

    public void setPropertyCategory(PropertyCategoryEntity propertyCategory) {
        this.propertyCategory = propertyCategory;
    }

    public List<UnityEntity> getUnities() {
        return unities;
    }

    public void setUnities(List<UnityEntity> unities) {
        this.unities = unities;
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

    public StreetEntity getStreet() {
        return street;
    }

    public void setStreet(StreetEntity street) {
        this.street = street;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public PropertyStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PropertyStatusEnum status) {
        this.status = status;
    }
}