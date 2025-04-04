package sales.sysconp.microservice.modules.project.street.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.project.street.application.dto.StreetCreateRequestDTO;
import sales.sysconp.microservice.modules.project.street.application.dto.StreetResponseDTO;
import sales.sysconp.microservice.modules.project.street.application.services.StreetService;

@RestController
@RequestMapping("street")
public class CreateStreetController {
    private final StreetService streetService;

    public CreateStreetController(StreetService streetService) {
        this.streetService = streetService;
    }

    @PostMapping("create")
    public StreetResponseDTO createStreet(
            @RequestBody @Valid StreetCreateRequestDTO streetCreateRequestDTO
    ) {
        return this.streetService.createStreet(streetCreateRequestDTO);
    }
}