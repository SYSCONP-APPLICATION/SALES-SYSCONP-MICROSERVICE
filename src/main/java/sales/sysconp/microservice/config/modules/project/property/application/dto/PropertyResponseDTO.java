package sales.sysconp.microservice.config.modules.project.property.application.dto;

import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.modules.project.collections.domain.models.CollectionModel;
import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;
import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyStatusEnum;
import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyTypeEnum;
import sales.sysconp.microservice.modules.project.property_category.domain.models.PropertyCategoryModel;
import sales.sysconp.microservice.modules.project.street.domain.models.StreetModel;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PropertyResponseDTO {
    private Long id;
    private UUID uuid;
    private String name;
    private String description;
    private PropertyStatusEnum status;
    private PropertyTypeEnum type;
    private ProjectModel project;
    private CollectionModel collection;
    private StreetModel street;
    private ClientModel client;
    private PropertyCategoryModel propertyCategory;
    private List<UnityModel> unities;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PropertyResponseDTO() {}

    public PropertyResponseDTO(Long id, UUID uuid, String name, String description, PropertyStatusEnum status, PropertyTypeEnum type, ProjectModel project, CollectionModel collection, StreetModel street, ClientModel client, PropertyCategoryModel propertyCategory, List<UnityModel> unities, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.type = type;
        this.project = project;
        this.status = status;
        this.collection = collection;
        this.street = street;
        this.client = client;
        this.propertyCategory = propertyCategory;
        this.unities = unities;
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

    public PropertyTypeEnum getType() {
        return type;
    }

    public void setType(PropertyTypeEnum type) {
        this.type = type;
    }

    public ProjectModel getProject() {
        return project;
    }

    public void setProject(ProjectModel project) {
        this.project = project;
    }

    public CollectionModel getCollection() {
        return collection;
    }

    public void setCollection(CollectionModel collection) {
        this.collection = collection;
    }

    public StreetModel getStreet() {
        return street;
    }

    public void setStreet(StreetModel street) {
        this.street = street;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public PropertyCategoryModel getPropertyCategory() {
        return propertyCategory;
    }

    public void setPropertyCategory(PropertyCategoryModel propertyCategory) {
        this.propertyCategory = propertyCategory;
    }

    public List<UnityModel> getUnities() {
        return unities;
    }

    public void setUnities(List<UnityModel> unities) {
        this.unities = unities;
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

    public PropertyStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PropertyStatusEnum status) {
        this.status = status;
    }
}
