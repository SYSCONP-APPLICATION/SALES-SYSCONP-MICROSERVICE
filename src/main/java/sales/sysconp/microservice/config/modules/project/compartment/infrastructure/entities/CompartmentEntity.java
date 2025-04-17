package sales.sysconp.microservice.config.modules.project.compartment.infrastructure.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import sales.sysconp.microservice.modules.project.compartment.domain.enums.CompartmentTypeEnum;
import sales.sysconp.microservice.modules.project.compartment.domain.enums.UnitOfMeditionEnum;
import sales.sysconp.microservice.modules.project.unity.infrastructure.entities.UnityEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "compartments")
@SQLDelete(sql = "UPDATE compartments SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class CompartmentEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(nullable = true)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UnitOfMeditionEnum heightMeasurement;

    @Column(nullable = false)
    private double height;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UnitOfMeditionEnum widthMeasurement;

    @Column(nullable = false)
    private double width;

    @Column(nullable = false)
    private CompartmentTypeEnum type;

    @ManyToOne()
    @JoinColumn(name = "unity_id", nullable = false, referencedColumnName = "id")
    private UnityEntity unity;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = true)
    private LocalDateTime updatedAt;

    @Column(updatable = true)
    private LocalDateTime deletedAt;

    public CompartmentEntity() {
    }

    public CompartmentEntity(Long id, UUID uuid, String description, UnitOfMeditionEnum heightMeasurement, double height, UnitOfMeditionEnum widthMeasurement, double width, CompartmentTypeEnum type, UnityEntity unity, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.description = description;
        this.heightMeasurement = heightMeasurement;
        this.height = height;
        this.widthMeasurement = widthMeasurement;
        this.width = width;
        this.type = type;
        this.unity = unity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UnitOfMeditionEnum getHeightMeasurement() {
        return heightMeasurement;
    }

    public void setHeightMeasurement(UnitOfMeditionEnum heightMeasurement) {
        this.heightMeasurement = heightMeasurement;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public UnitOfMeditionEnum getWidthMeasurement() {
        return widthMeasurement;
    }

    public void setWidthMeasurement(UnitOfMeditionEnum widthMeasurement) {
        this.widthMeasurement = widthMeasurement;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public CompartmentTypeEnum getType() {
        return type;
    }

    public void setType(CompartmentTypeEnum type) {
        this.type = type;
    }

    public UnityEntity getUnity() {
        return unity;
    }

    public void setUnity(UnityEntity unity) {
        this.unity = unity;
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
