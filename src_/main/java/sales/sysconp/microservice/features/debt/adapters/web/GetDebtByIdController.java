package sales.sysconp.microservice.features.debt.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.debt.application.dto.DebtResponseDTO;
import sales.sysconp.microservice.features.debt.application.services.DebtService;

@RestController
@RequestMapping("debt")
public class GetDebtByIdController {
    private final DebtService debtService;

    public GetDebtByIdController(DebtService debtService) {
        this.debtService = debtService;
    }

    @GetMapping("get/{id}")
    public DebtResponseDTO getDebtById(
            @PathVariable Long id
    ) {
        return this.debtService.getDebtById(id);
    }
}