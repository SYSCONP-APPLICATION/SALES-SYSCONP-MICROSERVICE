package sales.sysconp.microservice.modules.project.street.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.street.application.dto.StreetResponseDTO;
import sales.sysconp.microservice.modules.project.street.application.services.StreetService;

import java.util.UUID;

@RestController
@RequestMapping("street")
public class GetStreetByUUIDController {
    private final StreetService streetService;

    public GetStreetByUUIDController(StreetService streetService) {
        this.streetService = streetService;
    }

    @GetMapping("uuid/{uuid}")
    public StreetResponseDTO getStreetByUuid(
            @PathVariable UUID uuid
    ) {
        return this.streetService.getStreetByUuid(uuid);
    }
}