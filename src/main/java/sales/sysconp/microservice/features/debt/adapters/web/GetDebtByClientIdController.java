package sales.sysconp.microservice.features.debt.adapters.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.debt.application.dto.DebtResponseDTO;
import sales.sysconp.microservice.features.debt.application.services.DebtService;

import java.util.List;

@RestController
@RequestMapping("debt")
public class GetDebtByClientIdController {
    private final DebtService debtService;

    @Autowired
    public GetDebtByClientIdController(DebtService debtService) {
        this.debtService = debtService;
    }

    @GetMapping("client/{clientId}/all")
    public List<DebtResponseDTO> getDebtByClientId(
            @PathVariable Long clientId
    ) {
        return this.debtService.getAllDebtsByClientId(clientId);
    }
}