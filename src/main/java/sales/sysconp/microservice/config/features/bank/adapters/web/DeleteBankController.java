package sales.sysconp.microservice.config.features.bank.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.features.bank.application.services.BankService;

@RestController
@RequestMapping("bank")
public class DeleteBankController {
    private final BankService bankService;

    public DeleteBankController(BankService bankService) {
        this.bankService = bankService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteBank(
            @PathVariable("id") Long id
    ) {
        bankService.deleteBank(id);
    }
}