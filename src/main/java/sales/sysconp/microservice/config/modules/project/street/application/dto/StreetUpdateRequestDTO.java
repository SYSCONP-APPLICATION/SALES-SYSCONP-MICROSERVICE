package sales.sysconp.microservice.config.modules.project.street.application.dto;

import java.time.LocalDateTime;

public class StreetUpdateRequestDTO {
    private String name;

    private LocalDateTime updatedAt;

    public String getName() {
        return name;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
