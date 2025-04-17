package sales.sysconp.microservice.config.modules.project.measurements.application.dto;

import sales.sysconp.microservice.modules.project.compartment.domain.enums.UnitOfMeditionEnum;

import java.time.LocalDateTime;

public class MeasurementUpdateRequestDTO {
    private Double height;

    private Double width;

    private UnitOfMeditionEnum heightMeasurement;

    private UnitOfMeditionEnum widthMeasurement;

    private LocalDateTime updatedAt;

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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
