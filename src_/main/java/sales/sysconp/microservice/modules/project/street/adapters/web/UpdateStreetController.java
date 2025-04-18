package sales.sysconp.microservice.modules.project.street.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.project.street.application.dto.StreetResponseDTO;
import sales.sysconp.microservice.modules.project.street.application.dto.StreetUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.street.application.services.StreetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("street")
public class UpdateStreetController {
    private final StreetService streetService;

    public UpdateStreetController(StreetService streetService) {
        this.streetService = streetService;
    }

    @PutMapping("update/{id}")
    public StreetResponseDTO updateStreet(
            @PathVariable("id") Long id,
            @RequestBody @Valid StreetUpdateRequestDTO streetUpdateRequestDTO
    ) {
        return this.streetService.updateStreet(id, streetUpdateRequestDTO);
    }
}