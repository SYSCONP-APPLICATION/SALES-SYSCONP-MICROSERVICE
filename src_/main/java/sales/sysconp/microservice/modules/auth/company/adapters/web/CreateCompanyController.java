package sales.sysconp.microservice.modules.auth.company.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyCreateRequestDTO;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyResponseDTO;
import sales.sysconp.microservice.modules.auth.company.application.services.CompanyService;

@RestController
@RequestMapping("company")
public class CreateCompanyController {
    private final CompanyService companyService;

    public CreateCompanyController (CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("create")
    public CompanyResponseDTO createCompany(
            @RequestBody @Valid CompanyCreateRequestDTO companyCreateRequestDTO
    ) {
        return companyService.createCompany(companyCreateRequestDTO);
    }
}