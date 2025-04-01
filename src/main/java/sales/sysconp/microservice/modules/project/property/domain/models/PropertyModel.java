package sales.sysconp.microservice.modules.project.property.domain.models;

import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.modules.project.building.domain.models.BuildingModel;
import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyStatusEnum;
import sales.sysconp.microservice.modules.project.property_category.domain.models.PropertyCategoryModel;
import sales.sysconp.microservice.modules.project.property_type.domain.models.PropertyTypeModel;
import sales.sysconp.microservice.modules.project.zone.domain.models.ZoneModel;

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
    private BuildingModel building;
    private PropertyCategoryModel propertyCategory;
    private PropertyTypeModel propertyType;
    private ZoneModel zone;
    private ClientModel client;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public PropertyModel() {
    }

    public PropertyModel(Long id, UUID uuid, String name, String description, String area, Integer bedrooms, Integer bathrooms, PropertyStatusEnum status, BuildingModel building, PropertyCategoryModel propertyCategory, PropertyTypeModel propertyType, ZoneModel zone, ClientModel client, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
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

    public BuildingModel getBuilding() {
        return building;
    }

    public void setBuilding(BuildingModel building) {
        this.building = building;
    }

    public PropertyCategoryModel getPropertyCategory() {
        return propertyCategory;
    }

    public void setPropertyCategory(PropertyCategoryModel propertyCategory) {
        this.propertyCategory = propertyCategory;
    }

    public PropertyTypeModel getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyTypeModel propertyType) {
        this.propertyType = propertyType;
    }

    public ZoneModel getZone() {
        return zone;
    }

    public void setZone(ZoneModel zone) {
        this.zone = zone;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
