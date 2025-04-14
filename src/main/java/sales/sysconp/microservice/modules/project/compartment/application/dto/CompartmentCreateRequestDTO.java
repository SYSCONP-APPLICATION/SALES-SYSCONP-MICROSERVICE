package sales.sysconp.microservice.modules.project.compartment.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import sales.sysconp.microservice.modules.project.compartment.domain.enums.CompartmentTypeEnum;
import sales.sysconp.microservice.modules.project.compartment.domain.enums.UnitOfMeditionEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompartmentCreateRequestDTO {
    @NotNull(message = "Id cannot be null")
    private Long id;

    @NotNull(message = "Uuid cannot be null")
    private UUID uuid;

    @NotNull(message = "Description cannot be null")
    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotNull(message = "Height cannot be null")
    private double height;

    @NotNull(message = "Width cannot be null")
    private double width;

    @NotNull(message = "HeightMeasurement cannot be null")
    private UnitOfMeditionEnum heightMeasurement;

    @NotNull(message = "WidthMeasurement cannot be null")
    private UnitOfMeditionEnum widthMeasurement;

    @NotNull(message = "Type cannot be null")
    private CompartmentTypeEnum type;

    @NotNull(message = "UnityId cannot be null")
    private Long unityId;

    @NotNull(message = "CreatedAt cannot be null")
    private LocalDateTime createdAt;

    @NotNull(message = "UpdatedAt cannot be null")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getDescription() {
        return description;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public UnitOfMeditionEnum getHeightMeasurement() {
        return heightMeasurement;
    }

    public UnitOfMeditionEnum getWidthMeasurement() {
        return widthMeasurement;
    }

    public CompartmentTypeEnum getType() {
        return type;
    }

    public Long getUnityId() {
        return unityId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}

