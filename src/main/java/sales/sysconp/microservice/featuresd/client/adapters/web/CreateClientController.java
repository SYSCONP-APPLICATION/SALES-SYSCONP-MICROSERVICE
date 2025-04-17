package sales.sysconp.microservice.featuresd.client.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.client.application.dto.ClientCreateRequestDTO;
import sales.sysconp.microservice.features.client.application.dto.ClientResponseDTO;
import sales.sysconp.microservice.features.client.application.services.ClientService;

@RestController
@RequestMapping("client")
public class CreateClientController {
    private final ClientService clientService;

    public CreateClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("create")
    public ClientResponseDTO createClient(
            @RequestBody @Valid ClientCreateRequestDTO clientCreateRequestDTO
    ) {
        return clientService.createClient(clientCreateRequestDTO);
    }
}