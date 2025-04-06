package sales.sysconp.microservice.modules.project.measurements.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.measurements.application.dto.MeasurementResponseDTO;
import sales.sysconp.microservice.modules.project.measurements.application.services.MeasurementService;

import java.util.UUID;

@RestController
@RequestMapping("measurement")
public class GetMeasurementByUuidController {
    private final MeasurementService measurementService;

    public GetMeasurementByUuidController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping("uuid/{uuid}")
    public MeasurementResponseDTO getMeasurementByUUID(
            @PathVariable("uuid") UUID uuid
    ) {
        return this.measurementService.getMeasurementByUuid(uuid);
    }
}
