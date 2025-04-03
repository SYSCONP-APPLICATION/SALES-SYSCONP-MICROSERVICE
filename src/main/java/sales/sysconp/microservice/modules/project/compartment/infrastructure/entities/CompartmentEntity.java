package sales.sysconp.microservice.modules.project.compartment.infrastructure.entities;

import jakarta.persistence.*;
import sales.sysconp.microservice.modules.project.compartment.domain.enums.CompartmentTypeEnum;
import sales.sysconp.microservice.modules.project.unity.infrastructure.entities.UnityEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "compartments")
public class CompartmentEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private double area;

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

    public CompartmentEntity(Long id, UUID uuid, String description, double area, CompartmentTypeEnum type, UnityEntity unity, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
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
