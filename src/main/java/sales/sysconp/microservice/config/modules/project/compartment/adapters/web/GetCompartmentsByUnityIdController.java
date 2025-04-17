package sales.sysconp.microservice.config.modules.project.compartment.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.compartment.application.dto.CompartmentResponseDTO;
import sales.sysconp.microservice.modules.project.compartment.application.services.CompartmentService;

import java.util.List;

@RestController
@RequestMapping("compartment")
public class GetCompartmentsByUnityIdController {
    private final CompartmentService compartmentService;

    public GetCompartmentsByUnityIdController(CompartmentService compartmentService) {
        this.compartmentService = compartmentService;
    }

    @GetMapping("unity/{id}/all")
    public List<CompartmentResponseDTO> getCompartmentsByUnityId(
            @PathVariable("id") Long id
    ) {
        return compartmentService.getCompartmentsByUnityId(id);
    }
}
