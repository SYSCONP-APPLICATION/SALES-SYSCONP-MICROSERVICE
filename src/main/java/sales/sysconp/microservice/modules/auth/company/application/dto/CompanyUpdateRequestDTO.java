package sales.sysconp.microservice.modules.auth.company.application.dto;

import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class CompanyUpdateRequestDTO {
    @Size(min = 1, message = "Brand name must have at least 1 character")
    private String brandName;

    @Size(min = 1, message = "Commercial name must have at least 1 character")
    private String commercialName;

    private String location;

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

    public String getLocation() {
        return location;
    }
}
