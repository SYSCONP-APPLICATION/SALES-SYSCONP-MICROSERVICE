package sales.sysconp.microservice.modules.project.measurements.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import sales.sysconp.microservice.modules.project.compartment.domain.enums.UnitOfMeditionEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class MeasurementCreateRequestDTO {
    @NotNull(message = "Id não pode ser nulo")
    private Long id;

    @NotNull(message = "UUID não pode ser nulo")
    private UUID uuid;

    @Positive(message = "A altura deve ser um valor positivo")
    private Double height;

    @Positive(message = "A largura deve ser um valor positivo")
    private Double width;

    @NotNull(message = "A unidade de medida da altura não pode ser nula")
    private UnitOfMeditionEnum heightMeasurement;

    @NotNull(message = "A unidade de medida da largura não pode ser nula")
    private UnitOfMeditionEnum widthMeasurement;

    @NotNull(message = "A unidade associada não pode ser nula")
    private Long unityId;

    @NotNull(message = "O compo created_at eh obrigatoro")
    private LocalDateTime createdAt;

    @NotNull(message = "O compo updated_at eh obrigatoro")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    public UnitOfMeditionEnum getHeightMeasurement() {
        return heightMeasurement;
    }

    public UnitOfMeditionEnum getWidthMeasurement() {
        return widthMeasurement;
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
