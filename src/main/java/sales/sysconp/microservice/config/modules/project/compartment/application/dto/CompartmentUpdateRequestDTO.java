package sales.sysconp.microservice.config.modules.project.compartment.application.dto;

import sales.sysconp.microservice.modules.project.compartment.domain.enums.CompartmentTypeEnum;
import sales.sysconp.microservice.modules.project.compartment.domain.enums.UnitOfMeditionEnum;

public class CompartmentUpdateRequestDTO {
    private String description;

    private Double height;

    private Double width;

    private UnitOfMeditionEnum heightMeasurement;

    private UnitOfMeditionEnum widthMeasurement;

    private CompartmentTypeEnum type;

    public String getDescription() {
        return description;
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

    public CompartmentTypeEnum getType() {
        return type;
    }
}
