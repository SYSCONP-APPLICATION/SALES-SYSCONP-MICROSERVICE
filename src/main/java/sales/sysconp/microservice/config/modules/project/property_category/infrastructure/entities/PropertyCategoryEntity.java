package sales.sysconp.microservice.config.modules.project.property_category.infrastructure.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "property_categories")
@SQLDelete(sql = "UPDATE property_categories SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class PropertyCategoryEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "propertyCategory", cascade = CascadeType.ALL)
    private List<PropertyEntity> properties;

    @ManyToOne()
    @JoinColumn(name = "company_id", nullable = false, referencedColumnName = "id", unique = false)
    private CompanyEntity company;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = true)
    private LocalDateTime updatedAt;

    @Column(updatable = true)
    private LocalDateTime deletedAt;

    public PropertyCategoryEntity() {
    }

    public PropertyCategoryEntity(Long id, UUID uuid, String name, List<PropertyEntity> properties, CompanyEntity company, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.properties = properties;
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

    public List<PropertyEntity> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyEntity> properties) {
        this.properties = properties;
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
