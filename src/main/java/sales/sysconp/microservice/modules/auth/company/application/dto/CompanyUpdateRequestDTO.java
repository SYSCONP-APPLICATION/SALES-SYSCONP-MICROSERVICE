package sales.sysconp.microservice.modules.auth.company.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CompanyUpdateRequestDTO {
    @NotBlank(message = "O nome da marca não pode estar em branco")
    private String brandName;

    @NotBlank(message = "O nome comercial não pode estar em branco")
    private String commercialName;

    @NotNull(message = "A data de atualização não pode ser nula")
    private LocalDateTime updatedAt;

    public String getBrandName() {
        return brandName;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
