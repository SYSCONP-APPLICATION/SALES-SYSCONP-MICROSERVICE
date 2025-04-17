package sales.sysconp.microservice.config.modules.auth.company.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.auth.company.application.services.CompanyService;

@RestController
@RequestMapping("company")
public class DeleteCompanyController {
    private final CompanyService companyService;

    public DeleteCompanyController (CompanyService companyService) {
        this.companyService = companyService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteCompany(@PathVariable Long id) {
        this.companyService.deleteCompany(id);
    }
}
