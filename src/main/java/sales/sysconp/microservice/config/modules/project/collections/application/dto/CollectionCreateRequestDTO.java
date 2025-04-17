package sales.sysconp.microservice.config.modules.project.collections.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import sales.sysconp.microservice.modules.project.collections.domain.enums.CollectionTypeEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class CollectionCreateRequestDTO {
    @NotNull(message = "O ID  obrigat rio")
    private Long id;

    @NotNull(message = "O UUID  obrigat rio")
    private UUID uuid;

    @NotBlank(message = "O nome da coleta o  obrigat rio")
    private String name;

    @NotBlank(message = "A descri o da coleta o  obrigat rio")
    private String description;

    @NotNull(message = "O tipo da coleta o  obrigat rio")
    private CollectionTypeEnum type;

    @NotNull(message = "O projeto  obrigat rio")
    private Long projectId;

    @NotNull(message = "A data de cria o  obrigat rio")
    @PastOrPresent(message = "A data de cria o no pode ser no futuro")
    private LocalDateTime createdAt;

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

    public CollectionTypeEnum getType() {
        return type;
    }

    public Long getProjectId() {
        return projectId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
