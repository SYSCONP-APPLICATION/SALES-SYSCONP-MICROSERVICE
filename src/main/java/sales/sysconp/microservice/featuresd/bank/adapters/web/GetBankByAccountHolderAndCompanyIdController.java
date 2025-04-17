package sales.sysconp.microservice.featuresd.bank.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.bank.application.dto.BankResponseDTO;
import sales.sysconp.microservice.features.bank.application.services.BankService;

@RestController
@RequestMapping("bank")
public class GetBankByAccountHolderAndCompanyIdController {
    private final BankService bankService;

    public GetBankByAccountHolderAndCompanyIdController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("account-holder/{accountHolder}/company/{companyId}")
    public BankResponseDTO getBankByAccountHolder(
            @PathVariable("accountHolder") String accountHolder,
            @PathVariable("companyId") Long companyId
    ) {
        return bankService.getBankByAccountHolder(accountHolder, companyId);
    }
}