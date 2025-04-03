package sales.sysconp.microservice.modules.project.compartment.domain.models;

import sales.sysconp.microservice.modules.project.compartment.domain.enums.CompartmentTypeEnum;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompartmentModel {
    private Long id;
    private UUID uuid;
    private String description;
    private double area;
    private CompartmentTypeEnum type;
    private UnityModel unity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public CompartmentModel() {
    }

    public CompartmentModel(Long id, UUID uuid, String description, double area, CompartmentTypeEnum type, UnityModel unity, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.description = description;
        this.area = area;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public CompartmentTypeEnum getType() {
        return type;
    }

    public void setType(CompartmentTypeEnum type) {
        this.type = type;
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
