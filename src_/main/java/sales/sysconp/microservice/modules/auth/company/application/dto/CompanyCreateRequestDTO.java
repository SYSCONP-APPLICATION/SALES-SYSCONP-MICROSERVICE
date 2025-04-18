package sales.sysconp.microservice.modules.auth.company.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompanyCreateRequestDTO {
    @NotNull(message = "O ID não pode ser nulo")
    private Long id;

    @NotNull(message = "O UUID não pode ser nulo")
    private UUID uuid;

    @NotBlank(message = "O nome da marca não pode estar em branco")
    private String brandName;

    @NotBlank(message = "O nome comercial não pode estar em branco")
    private String commercialName;

    @NotBlank(message = "A localização não pode estar em branco")
    private String location;

    @NotNull(message = "A data de criação não pode ser nula")
    private LocalDateTime createdAt;

    @NotNull(message = "A data de atualização não pode ser nula")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getCommercialName() {
        return commercialName;
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
