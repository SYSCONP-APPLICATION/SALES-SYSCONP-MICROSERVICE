package sales.sysconp.microservice.config.modules.project.compartment.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentResponseDTO;
import sales.sysconp.microservice.modules.project.compartment.application.services.CompartmentService;

import java.util.UUID;

@RestController
@RequestMapping("compartment")
public class GetCompartmentByUUIDController {
    private final CompartmentService compartmentService;

    public GetCompartmentByUUIDController(CompartmentService compartmentService) {
        this.compartmentService = compartmentService;
    }

    @GetMapping("uuid/{uuid}")
    public CompartmentResponseDTO getCompartmentByUUID(
            @PathVariable("uuid") UUID uuid
    ) {
        return compartmentService.getCompartmentByUuid(uuid);
    }
}
