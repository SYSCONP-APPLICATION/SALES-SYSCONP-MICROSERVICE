package sales.sysconp.microservice.modules.project.street.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.street.application.services.StreetService;

@RestController
@RequestMapping("street")
public class DeleteStreetController {
    private final StreetService streetService;

    public DeleteStreetController(StreetService streetService) {
        this.streetService = streetService;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        this.streetService.deleteStreet(id);
    }
}
