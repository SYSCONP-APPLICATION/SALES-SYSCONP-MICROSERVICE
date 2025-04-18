package sales.sysconp.microservice.features.debt.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.debt.application.services.DebtService;

@RestController
@RequestMapping("debt")
public class DeleteDebtController {
    private final DebtService debtService;

    public DeleteDebtController(DebtService debtService) {
        this.debtService = debtService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteDebt(@PathVariable Long id) {
        debtService.deleteDebtById(id);
    }
}