package sales.sysconp.microservice.modules.project.street.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.street.application.dto.StreetResponseDTO;
import sales.sysconp.microservice.modules.project.street.application.services.StreetService;

@RestController
@RequestMapping("street")
public class GetStreetByIdController {
    private final StreetService streetService;

    public GetStreetByIdController(StreetService streetService) {
        this.streetService = streetService;
    }

    @GetMapping("get/{id}")
    public StreetResponseDTO getStreetById(
            @PathVariable Long id
    ) {
        return this.streetService.getStreetById(id);
    }
}