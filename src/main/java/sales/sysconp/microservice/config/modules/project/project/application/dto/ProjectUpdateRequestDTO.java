package sales.sysconp.microservice.config.modules.project.project.application.dto;

import jakarta.validation.constraints.NotNull;
import sales.sysconp.microservice.modules.project.project.domain.enums.ProjectStatusEnum;

import java.time.LocalDateTime;

public class ProjectUpdateRequestDTO {
    private String name;

    private String description;

    private ProjectStatusEnum status;

    private String location;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @NotNull(message = "A data de atualização do projeto é obrigatória")
    private LocalDateTime updatedAt;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ProjectStatusEnum getStatus() {
        return status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getLocation() {
        return location;
    }

    public void setStatus(ProjectStatusEnum status) {
        this.status = status;
    }
}
