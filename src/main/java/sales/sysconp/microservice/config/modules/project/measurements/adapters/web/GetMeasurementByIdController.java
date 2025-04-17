package sales.sysconp.microservice.config.modules.project.measurements.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementResponseDTO;
import sales.sysconp.microservice.modules.project.measurements.application.services.MeasurementService;

@RestController
@RequestMapping("measurement")
public class GetMeasurementByIdController {
    private final MeasurementService measurementService;

    public GetMeasurementByIdController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping("get/{id}")
    public MeasurementResponseDTO getMeasurementById(
            @PathVariable("id") Long id
    ) {
        return this.measurementService.getMeasurementById(id);
    }
}
