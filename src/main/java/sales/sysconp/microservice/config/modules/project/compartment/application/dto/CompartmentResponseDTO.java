package sales.sysconp.microservice.config.modules.project.compartment.application.dto;

import sales.sysconp.microservice.modules.project.compartment.domain.enums.CompartmentTypeEnum;
import sales.sysconp.microservice.modules.project.compartment.domain.enums.UnitOfMeditionEnum;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompartmentResponseDTO {
    private Long id;
    private UUID uuid;
    private String description;
    private double height;
    private double width;
    private UnitOfMeditionEnum heightMeasurement;
    private UnitOfMeditionEnum widthMeasurement;
    private CompartmentTypeEnum type;
    private UnityModel unity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CompartmentResponseDTO() {
    }

    public CompartmentResponseDTO(Long id, UUID uuid, String description, double height, double width, UnitOfMeditionEnum heightMeasurement, UnitOfMeditionEnum widthMeasurement, CompartmentTypeEnum type, UnityModel unity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.description = description;
        this.height = height;
        this.width = width;
        this.heightMeasurement = heightMeasurement;
        this.widthMeasurement = widthMeasurement;
        this.type = type;
        this.unity = unity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
}
