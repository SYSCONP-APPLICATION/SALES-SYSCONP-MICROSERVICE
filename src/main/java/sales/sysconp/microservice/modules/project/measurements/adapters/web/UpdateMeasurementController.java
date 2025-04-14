package sales.sysconp.microservice.modules.project.measurements.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementResponseDTO;
import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.measurements.application.services.MeasurementService;

@RestController
@RequestMapping("measurement")
public class UpdateMeasurementController {
    private final MeasurementService measurementService;

    public UpdateMeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PutMapping("update/{id}")
    public MeasurementResponseDTO updateMeasurement(
            @PathVariable Long id,
            @RequestBody @Valid MeasurementUpdateRequestDTO measurementUpdateRequestDTO
    ) {
        return measurementService.updateMeasurement(id, measurementUpdateRequestDTO);
    }
}
