package sales.sysconp.microservice.config.features.bank.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.bank.application.dto.BankResponseDTO;
import sales.sysconp.microservice.features.bank.application.services.BankService;

import java.util.UUID;

@RestController
@RequestMapping("bank")
public class GetBankByUUIDController {
    private final BankService bankService;

    public GetBankByUUIDController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("uuid/{uuid}")
    public BankResponseDTO getBankByUUID(
            @PathVariable("uuid") UUID uuid
    ) {
        return bankService.getBankByUuid(uuid);
    }
}