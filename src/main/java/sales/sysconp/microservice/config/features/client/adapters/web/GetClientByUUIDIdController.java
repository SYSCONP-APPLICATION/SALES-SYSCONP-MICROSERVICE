package sales.sysconp.microservice.config.features.client.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.client.application.dto.ClientResponseDTO;
import sales.sysconp.microservice.features.client.application.services.ClientService;

import java.util.UUID;

@RestController
@RequestMapping("client")
public class GetClientByUUIDIdController {
    private final ClientService clientService;

    public GetClientByUUIDIdController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("uuid/{uuid}")
    public ClientResponseDTO getClientByUUID(
            @PathVariable("uuid") UUID uuid
    ) {
        return this.clientService.getClientByUUID(uuid);
    }
}