package sales.sysconp.microservice.modules.project.compartment.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentResponseDTO;
import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.compartment.application.services.CompartmentService;

@RestController
@RequestMapping("compartment")
public class UpdateCompartmentController {
    private final CompartmentService compartmentService;

    public UpdateCompartmentController(CompartmentService compartmentService) {
        this.compartmentService = compartmentService;
    }

    @PutMapping("update/{id}")
    public CompartmentResponseDTO updateCompartment(
            @PathVariable("id") Long id,
            @RequestBody @Valid CompartmentUpdateRequestDTO compartmentUpdateRequestDTO
    ) {
        return this.compartmentService.updateCompartment(id, compartmentUpdateRequestDTO);
    }
}