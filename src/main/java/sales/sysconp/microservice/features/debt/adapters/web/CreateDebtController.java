package sales.sysconp.microservice.features.debt.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.debt.application.dto.DebtCreateRequestDTO;
import sales.sysconp.microservice.features.debt.application.dto.DebtResponseDTO;
import sales.sysconp.microservice.features.debt.application.services.DebtService;

@RestController
@RequestMapping("debt")
public class CreateDebtController {

    private final DebtService debtService;

    public CreateDebtController(DebtService debtService) {
        this.debtService = debtService;
    }

    @PostMapping("create")
    public DebtResponseDTO createDebt(
            @RequestBody @Valid DebtCreateRequestDTO debtCreateRequestDTO
    ) {
        return debtService.createDebt(debtCreateRequestDTO);
    }
}