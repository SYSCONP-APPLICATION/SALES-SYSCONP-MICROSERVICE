package sales.sysconp.microservice.config.modules.auth.company.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyResponseDTO;
import sales.sysconp.microservice.modules.auth.company.application.services.CompanyService;

import java.util.List;

@RestController
@RequestMapping("company")
public class GetCompanyByIdController {
    private final CompanyService companyService;

    public GetCompanyByIdController (CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("get/{id}")
    public CompanyResponseDTO getCompanyById(
            @PathVariable Long id
    ) {
        return this.companyService.findCompanyById(id);
    }
}
