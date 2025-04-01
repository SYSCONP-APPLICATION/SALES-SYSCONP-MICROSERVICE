package sales.sysconp.microservice.modules.project.property.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;
import sales.sysconp.microservice.modules.project.building.infrastructure.entities.BuildingEntity;
import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyStatusEnum;
import sales.sysconp.microservice.modules.project.property_category.infrastructure.entities.PropertyCategoryEntity;
import sales.sysconp.microservice.modules.project.property_type.infrastructure.entities.PropertyTypeEntity;
import sales.sysconp.microservice.modules.project.zone.infrastructure.entities.ZoneEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class PropertyModel {
    private Long id;
    private UUID uuid;
    private String name;
    private String description;
    private String area;
    private Integer bedrooms;
    private Integer bathrooms;
    private PropertyStatusEnum status;
    private BuildingEntity building;
    private PropertyCategoryEntity propertyCategory;
    private PropertyTypeEntity propertyType;
    private ZoneEntity zone;
    private ClientEntity client;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PropertyModel() {
    }

    public PropertyModel(Long id, UUID uuid, String name, String description, String area, Integer bedrooms, Integer bathrooms, PropertyStatusEnum status, BuildingEntity building, PropertyCategoryEntity propertyCategory, PropertyTypeEntity propertyType, ZoneEntity zone, ClientEntity client, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.area = area;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.status = status;
        this.building = building;
        this.propertyCategory = propertyCategory;
        this.propertyType = propertyType;
        this.zone = zone;
        this.client = client;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public PropertyStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PropertyStatusEnum status) {
        this.status = status;
    }

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }

    public PropertyCategoryEntity getPropertyCategory() {
        return propertyCategory;
    }

    public void setPropertyCategory(PropertyCategoryEntity propertyCategory) {
        this.propertyCategory = propertyCategory;
    }

    public PropertyTypeEntity getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyTypeEntity propertyType) {
        this.propertyType = propertyType;
    }

    public ZoneEntity getZone() {
        return zone;
    }

    public void setZone(ZoneEntity zone) {
        this.zone = zone;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
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
