package sales.sysconp.microservice.modules.project.compartment.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentCreateRequestDTO;
import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentResponseDTO;
import sales.sysconp.microservice.modules.project.compartment.application.services.CompartmentService;

@RestController
@RequestMapping("compartment")
public class CompartmentCreateController {
    private final CompartmentService compartmentService;

    public CompartmentCreateController(CompartmentService compartmentService) {
        this.compartmentService = compartmentService;
    }

    @PostMapping("create")
    public CompartmentResponseDTO createCompartment(
            @RequestBody @Valid CompartmentCreateRequestDTO compartmentCreateRequestDTO
    ) {
        return compartmentService.createCompartment(compartmentCreateRequestDTO);
    }
}