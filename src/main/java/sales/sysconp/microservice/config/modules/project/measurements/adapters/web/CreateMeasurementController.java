package sales.sysconp.microservice.config.modules.project.measurements.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementCreateRequestDTO;
import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementResponseDTO;
import sales.sysconp.microservice.modules.project.measurements.application.services.MeasurementService;

@RestController
@RequestMapping("measurement")
public class CreateMeasurementController {
    private final MeasurementService measurementService;

    public CreateMeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping("create")
    public MeasurementResponseDTO createMeasurement(
            @RequestBody @Valid MeasurementCreateRequestDTO measurementCreateRequestDTO
    ) {
        return this.measurementService.createMeasurement(measurementCreateRequestDTO);
    }
}