package sales.sysconp.microservice.featuresd.client.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.client.application.dto.ClientResponseDTO;
import sales.sysconp.microservice.features.client.application.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("client")
public class GetAllClientsByCompanyIdController {
    private final ClientService clientService;

    public GetAllClientsByCompanyIdController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("company/{id}/all")
    public List<ClientResponseDTO> getAllClientsByCompanyId(
            @PathVariable("id") Long id
    ) {
        return this.clientService.getAllClientsByCompanyId(id);
    }
}