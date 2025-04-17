package sales.sysconp.microservice.features.debt.adapters.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.debt.application.dto.DebtResponseDTO;
import sales.sysconp.microservice.features.debt.application.services.DebtService;

@RestController
@RequestMapping("/debt")
public class PayDebtController {

    private final DebtService debtService;

    @Autowired
    public PayDebtController(DebtService debtService) {
        this.debtService = debtService;
    }

    @PostMapping("/pay/{id}/by/{userId}")
    public DebtResponseDTO payDebt(
            @PathVariable Long id,
            @PathVariable Long userId
    ) {
        return debtService.payDebt(id, userId);
    }
}