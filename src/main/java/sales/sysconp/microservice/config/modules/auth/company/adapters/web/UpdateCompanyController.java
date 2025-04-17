package sales.sysconp.microservice.config.modules.auth.company.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyResponseDTO;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyUpdateRequestDTO;
import sales.sysconp.microservice.modules.auth.company.application.services.CompanyService;

@RestController
@RequestMapping("company")
public class UpdateCompanyController {
    private final CompanyService companyService;

    public UpdateCompanyController (CompanyService companyService) {
        this.companyService = companyService;
    }

    @PutMapping("update/{id}")
    public CompanyResponseDTO updateCompany(
            @PathVariable Long id,
            @RequestBody CompanyUpdateRequestDTO companyUpdateRequestDTO
    ) {
        return this.companyService.updateCompany(id, companyUpdateRequestDTO);
    }
}
