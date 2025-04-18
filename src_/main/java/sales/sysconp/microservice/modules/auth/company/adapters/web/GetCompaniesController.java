package sales.sysconp.microservice.modules.auth.company.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyResponseDTO;
import sales.sysconp.microservice.modules.auth.company.application.services.CompanyService;

import java.util.List;

@RestController
@RequestMapping("company")
public class GetCompaniesController {
    private final CompanyService companyService;

    public GetCompaniesController (CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("all")
    public List<CompanyResponseDTO> getAllCompanies() {
        return this.companyService.getAllCompanies();
    }
}
