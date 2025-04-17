package sales.sysconp.microservice.config.modules.project.compartment.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.compartment.application.services.CompartmentService;

@RestController
@RequestMapping("compartment")
public class DeleteCompartmentByIdController {
    private final CompartmentService compartmentService;

    public DeleteCompartmentByIdController(CompartmentService compartmentService) {
        this.compartmentService = compartmentService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteCompartmentById(
            @PathVariable("id") Long id
    ) {
        this.compartmentService.deleteCompartment(id);
    }
}