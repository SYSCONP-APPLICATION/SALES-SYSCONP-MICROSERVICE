package sales.sysconp.microservice.config.features.bank.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.bank.application.dto.BankCreateRequestDTO;
import sales.sysconp.microservice.features.bank.application.dto.BankResponseDTO;
import sales.sysconp.microservice.features.bank.application.services.BankService;

@RestController
@RequestMapping("bank")
public class BankCreateController {
    private final BankService bankService;

    public BankCreateController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("create")
    public BankResponseDTO createBank(
            @RequestBody @Valid BankCreateRequestDTO bankCreateRequestDTO
    ) {
        return bankService.createBank(bankCreateRequestDTO);
    }
}
