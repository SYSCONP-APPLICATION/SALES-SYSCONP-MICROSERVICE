package sales.sysconp.microservice.features.client.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.client.application.dto.ClientResponseDTO;
import sales.sysconp.microservice.features.client.application.services.ClientService;

@RestController
@RequestMapping("client")
public class GetClientByIdController {
    private final ClientService clientService;

    public GetClientByIdController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("get/{id}")
    public ClientResponseDTO getClientById(
            @PathVariable("id") Long id
    ) {
        return this.clientService.getClientById(id);
    }
}