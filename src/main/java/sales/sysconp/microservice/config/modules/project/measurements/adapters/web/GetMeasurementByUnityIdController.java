package sales.sysconp.microservice.config.modules.project.measurements.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementResponseDTO;
import sales.sysconp.microservice.modules.project.measurements.application.services.MeasurementService;

@RestController
@RequestMapping("measurement")
public class GetMeasurementByUnityIdController {
    private final MeasurementService measurementService;

    public GetMeasurementByUnityIdController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping("unity/{id}")
    public MeasurementResponseDTO getMeasurementByUnityId(
            @PathVariable("id") Long id
    ) {
        return this.measurementService.getMeasurementByUnityId(id);
    }
}
