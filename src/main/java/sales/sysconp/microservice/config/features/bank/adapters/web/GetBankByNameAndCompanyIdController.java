package sales.sysconp.microservice.config.features.bank.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.bank.application.dto.BankResponseDTO;
import sales.sysconp.microservice.features.bank.application.services.BankService;

@RestController
@RequestMapping("bank")
public class GetBankByNameAndCompanyIdController {
    private final BankService bankService;

    public GetBankByNameAndCompanyIdController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("name/{name}/company/{companyId}")
    public BankResponseDTO getBankByName(
            @PathVariable("name") String name,
            @PathVariable("companyId") Long companyId
    ) {
        return bankService.getBankByName(name, companyId);
    }
}