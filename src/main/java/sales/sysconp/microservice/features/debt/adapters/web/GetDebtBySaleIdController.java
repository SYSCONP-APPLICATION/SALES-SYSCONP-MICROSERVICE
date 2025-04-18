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
public class GetDebtBySaleIdController {
    private final DebtService debtService;

    @Autowired
    public GetDebtBySaleIdController(DebtService debtService) {
        this.debtService = debtService;
    }

    @GetMapping("sale/{saleId}/all")
    public List<DebtResponseDTO> getDebtBySaleId(
            @PathVariable Long saleId
    ) {
        return this.debtService.getAllDebtsBySaleId(saleId);
    }
}