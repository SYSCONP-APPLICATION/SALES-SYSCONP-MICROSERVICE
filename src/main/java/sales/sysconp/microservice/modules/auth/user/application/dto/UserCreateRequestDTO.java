package sales.sysconp.microservice.modules.auth.user.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserCreateRequestDTO {
    @NotNull(message = "id is required")
    private Long id;

    @NotNull(message = "uuid is required")
    @NotEmpty(message = "uuid is required")
    private UUID uuid;

    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    private String name;

    @NotNull(message = "createdAt is required")
    private LocalDateTime createdAt;

    @NotNull(message = "updatedAt is required")
    private LocalDateTime updatedAt;
}