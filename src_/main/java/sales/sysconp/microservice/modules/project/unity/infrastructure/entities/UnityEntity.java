package sales.sysconp.microservice.modules.project.unity.infrastructure.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;
import sales.sysconp.microservice.modules.project.compartment.infrastructure.entities.CompartmentEntity;
import sales.sysconp.microservice.modules.project.measurements.infrastructure.entities.MeasurementEntity;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;
import sales.sysconp.microservice.modules.project.unity.domain.enums.UnityStatusEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "unities")
@SQLDelete(sql = "UPDATE unities SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class UnityEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(nullable = true)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "property_id", nullable = false, referencedColumnName = "id")
    private PropertyEntity property;

    @OneToMany(mappedBy = "unity", cascade = CascadeType.ALL)
    private List<CompartmentEntity> compartments;

    @OneToOne()
    @JoinColumn(name = "measurement_id", nullable = true, referencedColumnName = "id")
    private MeasurementEntity measurement;

    @Column(nullable = true)
    private UnityStatusEnum status;

    @ManyToOne()
    @JoinColumn(name = "sale_id", nullable = true, referencedColumnName = "id")
    private SaleEntity sale;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = true)
    private LocalDateTime updatedAt;

    @Column(updatable = true)
    private LocalDateTime deletedAt;

    public UnityEntity() {
    }

    public UnityEntity(Long id, UUID uuid, String name, PropertyEntity property, List<CompartmentEntity> compartments, MeasurementEntity measurement, UnityStatusEnum status, SaleEntity sale, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.property = property;
        this.compartments = compartments;
        this.measurement = measurement;
        this.status = status;
        this.sale = sale;
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

    public PropertyEntity getProperty() {
        return property;
    }

    public void setProperty(PropertyEntity property) {
        this.property = property;
    }

    public List<CompartmentEntity> getCompartments() {
        return compartments;
    }

    public void setCompartments(List<CompartmentEntity> compartments) {
        this.compartments = compartments;
    }

    public MeasurementEntity getMeasurement() {
        return measurement;
    }

    public void setMeasurement(MeasurementEntity measurement) {
        this.measurement = measurement;
    }

    public UnityStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UnityStatusEnum status) {
        this.status = status;
    }

    public SaleEntity getSale() {
        return sale;
    }

    public void setSale(SaleEntity sale) {
        this.sale = sale;
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
