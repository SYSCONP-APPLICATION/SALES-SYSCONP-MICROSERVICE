package sales.sysconp.microservice.features.client.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.client.application.dto.ClientResponseDTO;
import sales.sysconp.microservice.features.client.application.dto.ClientUpdateRequestDTO;
import sales.sysconp.microservice.features.client.application.services.ClientService;

@RestController
@RequestMapping("client")
public class UpdateClientController {
    private final ClientService clientService;

    public UpdateClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PutMapping("update/{id}")
    public ClientResponseDTO updateClient(
            @PathVariable("id") Long id,
            @RequestBody @Valid ClientUpdateRequestDTO clientUpdateRequestDTO
    ) {
        return clientService.updateClient(id, clientUpdateRequestDTO);
    }
}