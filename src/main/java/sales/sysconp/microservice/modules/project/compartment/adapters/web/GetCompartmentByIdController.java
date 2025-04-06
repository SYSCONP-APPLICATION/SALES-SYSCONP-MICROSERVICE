package sales.sysconp.microservice.modules.project.compartment.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentResponseDTO;
import sales.sysconp.microservice.modules.project.compartment.application.services.CompartmentService;

@RestController
@RequestMapping("compartment")
public class GetCompartmentByIdController {
    private final CompartmentService compartmentService;

    public GetCompartmentByIdController(CompartmentService compartmentService) {
        this.compartmentService = compartmentService;
    }

    @GetMapping("get/{id}")
    public CompartmentResponseDTO getCompartmentById(
            @PathVariable("id") Long id
    ) {
        return compartmentService.getCompartmentById(id);
    }
}