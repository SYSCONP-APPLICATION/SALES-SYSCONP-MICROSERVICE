package sales.sysconp.microservice.featuresd.bank.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.bank.application.dto.BankResponseDTO;
import sales.sysconp.microservice.features.bank.application.services.BankService;

@RestController
@RequestMapping("bank")
public class GetBankByIdController {
    private final BankService bankService;

    public GetBankByIdController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("get/{id}")
    public BankResponseDTO getBankById(
            @PathVariable("id") Long id
    ) {
        return bankService.getBankById(id);
    }
}