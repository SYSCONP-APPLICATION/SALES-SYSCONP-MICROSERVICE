package sales.sysconp.microservice.modules.project.project.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import sales.sysconp.microservice.modules.project.project.domain.enums.ProjectStatusEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProjectCreateRequestDTO {
    @NotNull(message = "O ID é obrigatório")
    private Long id;

    @NotNull(message = "O UUID é obrigatório")
    private UUID uuid;

    @NotBlank(message = "O nome do projeto não pode estar em branco")
    private String name;

    @NotBlank(message = "A descrição do projeto não pode estar em branco")
    private String description;

    @NotBlank(message = "A localização do projeto é obrigatória")
    private String location;

    @NotNull(message = "O status do projeto é obrigatório")
    private ProjectStatusEnum status;

    @NotNull(message = "A data de início do projeto é obrigatória")
    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @NotNull(message = "A empresa é obrigatória")
    private Long companyId;

    @NotNull(message = "A data de criação do projeto é obrigatória")
    private LocalDateTime createdAt;

    @NotNull(message = "A data de atualização do projeto é obrigatória")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

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

    public Long getCompanyId() {
        return companyId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getLocation() {
        return location;
    }
}