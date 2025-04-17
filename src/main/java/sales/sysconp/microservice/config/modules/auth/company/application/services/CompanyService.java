package sales.sysconp.microservice.config.modules.auth.company.application.services;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyCreateRequestDTO;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyResponseDTO;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyUpdateRequestDTO;
import sales.sysconp.microservice.modules.auth.company.application.ports.in.CompanyServiceInPort;
import sales.sysconp.microservice.modules.auth.company.domain.mapper.CompanyMapper;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.repository.CompanyRepositoryAdapter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CompanyService implements CompanyServiceInPort {
    private final CompanyRepositoryAdapter companyRepositoryAdapter;
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyRepositoryAdapter companyRepositoryAdapter, CompanyMapper companyMapper) {
        this.companyRepositoryAdapter = companyRepositoryAdapter;
        this.companyMapper = companyMapper;
    }

    @Override
    public List<CompanyResponseDTO> getAllCompanies() {
        return this.companyRepositoryAdapter
                .findAll()
                .stream()
                .map(companyMapper::toResponseDTO)
                .toList();
    }

    @Override
    public CompanyResponseDTO findCompanyById(Long id) {
        CompanyModel model = this.companyRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Empresa nao encontrado!"));

        return companyMapper.toResponseDTO(model);
    }

    @Override
    public CompanyResponseDTO updateCompany(Long id, CompanyUpdateRequestDTO companyUpdateRequestDTO) {
        CompanyModel model = this.companyRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrado!"));

        Optional<CompanyModel> companyByBrandName = this.companyRepositoryAdapter
                .findByBrandName(companyUpdateRequestDTO.getBrandName());

        if (companyByBrandName.isPresent() && companyByBrandName.get().getId() != model.getId()) {
            throw new EntityExistsException("Já existe uma empresa com esse nome de marca!");
        }

        Optional<CompanyModel> companyByCommercialName = this.companyRepositoryAdapter
                .findByCommercialName(companyUpdateRequestDTO.getCommercialName());

        if (companyByCommercialName.isPresent() && companyByCommercialName.get().getId() != model.getId()) {
            throw new EntityExistsException("Já existe uma empresa com esse nome comercial!");
        }

        if (companyUpdateRequestDTO.getBrandName() != null) {
            model.setBrandName(companyUpdateRequestDTO.getBrandName());
        }
        if (companyUpdateRequestDTO.getCommercialName() != null) {
            model.setCommercialName(companyUpdateRequestDTO.getCommercialName());
        }
        if (companyUpdateRequestDTO.getUpdatedAt() != null) {
            model.setUpdatedAt(companyUpdateRequestDTO.getUpdatedAt());
        }
        if (companyUpdateRequestDTO.getLocation() != null) {
            model.setLocation(companyUpdateRequestDTO.getLocation());
        }

        return companyMapper.toResponseDTO(this.companyRepositoryAdapter.save(model));
    }

    @Override
    public CompanyResponseDTO createCompany(CompanyCreateRequestDTO companyCreateRequestDTO) {
        Optional<CompanyModel> companyById = this.companyRepositoryAdapter.findById(companyCreateRequestDTO.getId());

        if (companyById.isPresent()) {
            throw new EntityExistsException("Já existe uma empresa com esse id!");
        }

        Optional<CompanyModel> companyByUuid = this.companyRepositoryAdapter.findByUUID(companyCreateRequestDTO.getUuid());

        if (companyByUuid.isPresent()) {
            throw new EntityExistsException("Já existe uma empresa com esse uuid!");
        }

        Optional<CompanyModel> companyByBrandName = this.companyRepositoryAdapter.findByBrandName(companyCreateRequestDTO.getBrandName());

        if (companyByBrandName.isPresent()) {
            throw new EntityExistsException("Já existe uma empresa com esse nome de marca!");
        }

        Optional<CompanyModel> companyByCommercialName = this.companyRepositoryAdapter.findByCommercialName(companyCreateRequestDTO.getCommercialName());

        if (companyByCommercialName.isPresent()) {
            throw new EntityExistsException("Já existe uma empresa com esse nome comercial!");
        }

        CompanyModel companyModel = new CompanyModel();

        companyModel.setId(companyCreateRequestDTO.getId());
        companyModel.setUuid(companyCreateRequestDTO.getUuid());
        companyModel.setCommercialName(companyCreateRequestDTO.getCommercialName());
        companyModel.setBrandName(companyCreateRequestDTO.getBrandName());
        companyModel.setLocation(companyCreateRequestDTO.getLocation());
        companyModel.setCreatedAt(companyCreateRequestDTO.getCreatedAt());
        companyModel.setUpdatedAt(companyCreateRequestDTO.getUpdatedAt());

        CompanyModel savedCompanyModel = companyRepositoryAdapter.save(companyModel);
        return companyMapper.toResponseDTO(savedCompanyModel);
    }

    @Override
    public void deleteCompany(Long id) {
        this.companyRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Empresa nao encontrado!"));

        this.companyRepositoryAdapter.deleteById(id);
    }
}