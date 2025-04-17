package sales.sysconp.microservice.config.modules.project.street.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.project.street.application.dto.StreetResponseDTO;
import sales.sysconp.microservice.modules.project.street.application.services.StreetService;

import java.util.List;

@RestController
@RequestMapping("street")
public class GetStreetsByProjectIdController {
    private final StreetService streetService;

    public GetStreetsByProjectIdController (StreetService streetService) {
        this.streetService = streetService;
    }

    @GetMapping("project/{projectId}/all")
    public List<StreetResponseDTO> createStreet(
            @PathVariable("projectId") Long projectId
    ) {
        return this.streetService.getAllStreetsByProjectId(projectId);
    }
}
