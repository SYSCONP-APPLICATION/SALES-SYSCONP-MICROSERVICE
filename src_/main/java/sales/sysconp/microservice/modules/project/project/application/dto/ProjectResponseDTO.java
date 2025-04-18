package sales.sysconp.microservice.modules.project.project.application.dto;

import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.project.collections.domain.models.CollectionModel;
import sales.sysconp.microservice.modules.project.project.domain.enums.ProjectStatusEnum;
import sales.sysconp.microservice.modules.project.property.domain.models.PropertyModel;
import sales.sysconp.microservice.modules.project.street.domain.models.StreetModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ProjectResponseDTO {
    private Long id;
    private UUID uuid;
    private String name;
    private String description;
    private ProjectStatusEnum status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<StreetModel> streets;
    private List<PropertyModel> properties;
    private List<CollectionModel> collections;
    private CompanyModel company;
    private StreetModel street;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProjectResponseDTO() {}

    public ProjectResponseDTO(Long id, UUID uuid, String name, String description, ProjectStatusEnum status, LocalDateTime startDate, LocalDateTime endDate, List<StreetModel> streets, List<PropertyModel> properties, List<CollectionModel> collections, CompanyModel company, StreetModel street, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.streets = streets;
        this.properties = properties;
        this.collections = collections;
        this.company = company;
        this.street = street;
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

    public ProjectStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ProjectStatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<StreetModel> getStreets() {
        return streets;
    }

    public void setStreets(List<StreetModel> streets) {
        this.streets = streets;
    }

    public List<PropertyModel> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyModel> properties) {
        this.properties = properties;
    }

    public List<CollectionModel> getCollections() {
        return collections;
    }

    public void setCollections(List<CollectionModel> collections) {
        this.collections = collections;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
        this.company = company;
    }

    public StreetModel getStreet() {
        return street;
    }

    public void setStreet(StreetModel street) {
        this.street = street;
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