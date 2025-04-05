package sales.sysconp.microservice.modules.project.property.application.dto;

import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyTypeEnum;

import java.time.LocalDateTime;

public class PropertyUpdateRequestDTO {
    private String name;

    private String description;

    private PropertyTypeEnum type;

    private Long projectId;

    private Long collectionId;

    private Long streetId;

    private Long clientId;

    private Long propertyCategoryId;

    private LocalDateTime updatedAt;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public PropertyTypeEnum getType() {
        return type;
    }

    public Long getProjectId() {
        return projectId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public Long getStreetId() {
        return streetId;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getPropertyCategoryId() {
        return propertyCategoryId;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
