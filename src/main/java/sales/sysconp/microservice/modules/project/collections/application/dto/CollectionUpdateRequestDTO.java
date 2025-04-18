package sales.sysconp.microservice.modules.project.collections.application.dto;

import sales.sysconp.microservice.modules.project.collections.domain.enums.CollectionTypeEnum;

import java.time.LocalDateTime;

public class CollectionUpdateRequestDTO {
    private String name;
    private String description;
    private Long projectId;
    private CollectionTypeEnum type;
    private LocalDateTime updatedAt;

    public Long getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CollectionTypeEnum getType() {
        return type;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
