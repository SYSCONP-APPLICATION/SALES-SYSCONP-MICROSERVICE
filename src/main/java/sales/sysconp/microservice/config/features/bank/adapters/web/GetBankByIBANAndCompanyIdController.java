package sales.sysconp.microservice.config.features.bank.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.bank.application.dto.BankResponseDTO;
import sales.sysconp.microservice.features.bank.application.services.BankService;

@RestController
@RequestMapping("bank")
public class GetBankByIBANAndCompanyIdController {
    private final BankService bankService;

    public GetBankByIBANAndCompanyIdController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("iban/{iban}/company/{companyId}")
    public BankResponseDTO getBankByIban(
            @PathVariable("iban") String iban,
            @PathVariable("companyId") Long companyId
    ) {
        return bankService.getBankByIban(iban, companyId);
    }
}