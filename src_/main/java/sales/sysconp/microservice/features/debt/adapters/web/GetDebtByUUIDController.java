package sales.sysconp.microservice.features.debt.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.debt.application.dto.DebtResponseDTO;
import sales.sysconp.microservice.features.debt.application.services.DebtService;

import java.util.UUID;

@RestController
@RequestMapping("debt")
public class GetDebtByUUIDController {
    private final DebtService debtService;

    public GetDebtByUUIDController(DebtService debtService) {
        this.debtService = debtService;
    }

    @GetMapping("uuid/{uuid}")
    public DebtResponseDTO getDebtByUUID(
            @PathVariable UUID uuid
    ) {
        return this.debtService.getDebtByUUID(uuid);
    }
}