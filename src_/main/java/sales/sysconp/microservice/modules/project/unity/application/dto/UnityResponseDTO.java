package sales.sysconp.microservice.modules.project.unity.application.dto;

import sales.sysconp.microservice.modules.project.compartment.domain.models.CompartmentModel;
import sales.sysconp.microservice.modules.project.measurements.domain.models.MeasurementModel;
import sales.sysconp.microservice.modules.project.property.domain.models.PropertyModel;
import sales.sysconp.microservice.modules.project.unity.domain.enums.UnityStatusEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class UnityResponseDTO {
    private Long id;
    private UUID uuid;
    private String name;
    private PropertyModel property;
    private UnityStatusEnum status;
    private List<CompartmentModel> compartments;
    private MeasurementModel measurement;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UnityResponseDTO() {
    }

    public UnityResponseDTO(Long id, UUID uuid, String name, UnityStatusEnum status, PropertyModel property, List<CompartmentModel> compartments, MeasurementModel measurement, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.property = property;
        this.status = status;
        this.compartments = compartments;
        this.measurement = measurement;
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

    public PropertyModel getProperty() {
        return property;
    }

    public void setProperty(PropertyModel property) {
        this.property = property;
    }

    public List<CompartmentModel> getCompartments() {
        return compartments;
    }

    public void setCompartments(List<CompartmentModel> compartments) {
        this.compartments = compartments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MeasurementModel getMeasurement() {
        return measurement;
    }

    public void setMeasurement(MeasurementModel measurement) {
        this.measurement = measurement;
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

    public UnityStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UnityStatusEnum status) {
        this.status = status;
    }
}
