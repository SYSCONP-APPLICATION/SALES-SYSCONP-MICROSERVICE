package sales.sysconp.microservice.features.bank.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.features.bank.application.dto.BankResponseDTO;
import sales.sysconp.microservice.features.bank.application.dto.BankUpdateRequestDTO;
import sales.sysconp.microservice.features.bank.application.services.BankService;

@RestController
@RequestMapping("bank")
public class UpdateBankController {
    private final BankService bankService;

    public UpdateBankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PutMapping("update/{id}")
    public BankResponseDTO updateBank(
            @PathVariable("id") Long id,
            @RequestBody @Valid BankUpdateRequestDTO bankUpdateRequestDTO
    ) {
        return this.bankService.updateBank(id, bankUpdateRequestDTO);
    }
}
