package sales.sysconp.microservice.config.features.bank.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.bank.application.dto.BankResponseDTO;
import sales.sysconp.microservice.features.bank.application.services.BankService;

@RestController
@RequestMapping("bank")
public class GetBankByAcronymAndCompanyIdController {
    private final BankService bankService;

    public GetBankByAcronymAndCompanyIdController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("acronym/{acronym}/company/{companyId}")
    public BankResponseDTO getBankByAcronym(
            @PathVariable("acronym") String acronym,
            @PathVariable("companyId") Long companyId
    ) {
        return bankService.getBankByAcronym(acronym, companyId);
    }
}