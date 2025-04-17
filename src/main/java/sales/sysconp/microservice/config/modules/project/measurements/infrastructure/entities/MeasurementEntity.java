package sales.sysconp.microservice.config.modules.project.measurements.infrastructure.entities;

import jakarta.persistence.*;
import sales.sysconp.microservice.modules.project.compartment.domain.enums.UnitOfMeditionEnum;
import sales.sysconp.microservice.modules.project.unity.infrastructure.entities.UnityEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "measurements")
public class MeasurementEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private double height;

    @Column(nullable = false)
    private double width;

    @Column(nullable = false)
    private UnitOfMeditionEnum heightMeasurement;

    @Column(nullable = false)
    private UnitOfMeditionEnum widthMeasurement;

    @OneToOne
    @JoinColumn(name = "unity_id", nullable = false, referencedColumnName = "id")
    private UnityEntity unity;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = true)
    private LocalDateTime updatedAt;

    @Column(updatable = true)
    private LocalDateTime deletedAt;

    public MeasurementEntity() {
    }

    public MeasurementEntity(Long id, UUID uuid, double height, double width, UnitOfMeditionEnum heightMeasurement, UnitOfMeditionEnum widthMeasurement, UnityEntity unity, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.height = height;
        this.width = width;
        this.heightMeasurement = heightMeasurement;
        this.widthMeasurement = widthMeasurement;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public UnitOfMeditionEnum getHeightMeasurement() {
        return heightMeasurement;
    }

    public void setHeightMeasurement(UnitOfMeditionEnum heightMeasurement) {
        this.heightMeasurement = heightMeasurement;
    }

    public UnitOfMeditionEnum getWidthMeasurement() {
        return widthMeasurement;
    }

    public void setWidthMeasurement(UnitOfMeditionEnum widthMeasurement) {
        this.widthMeasurement = widthMeasurement;
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
