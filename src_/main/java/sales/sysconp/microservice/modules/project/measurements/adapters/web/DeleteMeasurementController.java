package sales.sysconp.microservice.modules.project.measurements.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.measurements.application.services.MeasurementService;

@RestController
@RequestMapping("measurement")
public class DeleteMeasurementController {
    private final MeasurementService measurementService;

    public DeleteMeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteMeasurement(
            @PathVariable Long id
    ) {
        measurementService.deleteMeasurement(id);
    }
}
