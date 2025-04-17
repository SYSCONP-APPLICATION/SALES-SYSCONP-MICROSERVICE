package sales.sysconp.microservice.config.modules.project.measurements.domain.models;

import sales.sysconp.microservice.modules.project.compartment.domain.enums.UnitOfMeditionEnum;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class MeasurementModel {
    private Long id;
    private UUID uuid;
    private double height;
    private double width;
    private UnitOfMeditionEnum heightMeasurement;
    private UnitOfMeditionEnum widthMeasurement;
    private UnityModel unity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public MeasurementModel() {
    }

    public MeasurementModel(Long id, UUID uuid, double height, double width, UnitOfMeditionEnum heightMeasurement, UnitOfMeditionEnum widthMeasurement, UnityModel unity, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
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

    public UnityModel getUnity() {
        return unity;
    }

    public void setUnity(UnityModel unity) {
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
