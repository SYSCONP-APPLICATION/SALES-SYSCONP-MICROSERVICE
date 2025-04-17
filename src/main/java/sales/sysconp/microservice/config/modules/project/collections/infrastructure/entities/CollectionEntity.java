package sales.sysconp.microservice.config.modules.project.collections.infrastructure.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import sales.sysconp.microservice.modules.project.collections.domain.enums.CollectionTypeEnum;
import sales.sysconp.microservice.modules.project.project.infrastructure.entities.ProjectEntity;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "collections")
@SQLDelete(sql = "UPDATE collections SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class CollectionEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private CollectionTypeEnum type;

    @ManyToOne()
    @JoinColumn(name = "project_id", nullable = false, referencedColumnName = "id")
    private ProjectEntity project;

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL)
    private List<PropertyEntity> properties;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = true)
    private LocalDateTime updatedAt;

    @Column(updatable = true)
    private LocalDateTime deletedAt;

    public CollectionEntity() {
    }

    public CollectionEntity(Long id, UUID uuid, String name, String description, CollectionTypeEnum type, ProjectEntity project, List<PropertyEntity> properties, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.type = type;
        this.project = project;
        this.properties = properties;
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

    public CollectionTypeEnum getType() {
        return type;
    }

    public void setType(CollectionTypeEnum type) {
        this.type = type;
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
