package sales.sysconp.microservice.config.modules.auth.company.application.ports.in;

import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyCreateRequestDTO;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyResponseDTO;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyUpdateRequestDTO;

import java.util.List;

public interface CompanyServiceInPort {
    List<CompanyResponseDTO> getAllCompanies();

    CompanyResponseDTO findCompanyById(Long id);

    CompanyResponseDTO updateCompany(Long id, CompanyUpdateRequestDTO companyUpdateRequestDTO);

    CompanyResponseDTO createCompany(CompanyCreateRequestDTO companyCreateRequestDTO);

    void deleteCompany(Long id);
}
