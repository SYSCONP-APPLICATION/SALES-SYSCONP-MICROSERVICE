package sales.sysconp.microservice.featuresd.client.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.client.application.services.ClientService;

@RestController
@RequestMapping("client")
public class DeleteClientByIdController {
    private final ClientService clientService;

    public DeleteClientByIdController(ClientService clientService) {
        this.clientService = clientService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteClientById(
            @PathVariable("id") Long id
    ) {
        clientService.deleteClientById(id);
    }
}