package sales.sysconp.microservice.features.system_payment_configuration.application.services;

import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.system_payment_configuration.infrastructure.repository.SystemPaymentConfigurationRepositoryAdapter;
import sales.sysconp.microservice.features.system_payment_configuration.application.ports.in.SystemPaymentConfigurationServiceInPort;
import sales.sysconp.microservice.features.system_payment_configuration.application.dto.SystemPaymentConfigurationCreateRequestDTO;
import sales.sysconp.microservice.features.system_payment_configuration.application.dto.SystemPaymentConfigurationUpdateRequestDTO;
import sales.sysconp.microservice.features.system_payment_configuration.application.dto.SystemPaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.system_payment_configuration.domain.mappers.SystemPaymentConfigurationMapper;
import sales.sysconp.microservice.features.system_payment_configuration.domain.models.SystemPaymentConfigurationModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.repository.CompanyRepositoryAdapter;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class SystemPaymentConfigurationService implements SystemPaymentConfigurationServiceInPort {
    private final SystemPaymentConfigurationRepositoryAdapter systemPaymentConfigurationRepositoryAdapter;
    private final CompanyRepositoryAdapter companyRepositoryAdapter;
    private final SystemPaymentConfigurationMapper systemPaymentConfigurationMapper;

    public SystemPaymentConfigurationService (SystemPaymentConfigurationRepositoryAdapter systemPaymentConfigurationRepositoryAdapter, CompanyRepositoryAdapter companyRepositoryAdapter, SystemPaymentConfigurationMapper systemPaymentConfigurationMapper) {
        this.systemPaymentConfigurationRepositoryAdapter = systemPaymentConfigurationRepositoryAdapter;
        this.companyRepositoryAdapter = companyRepositoryAdapter;
        this.systemPaymentConfigurationMapper = systemPaymentConfigurationMapper;
    }

    @Override
    public SystemPaymentConfigurationResponseDTO getSystemPaymentConfigurationByCompanyId(Long companyId) {
        this.companyRepositoryAdapter
                .findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));

        SystemPaymentConfigurationModel systemPaymentConfigurationModel = systemPaymentConfigurationRepositoryAdapter.findByCompanyId(companyId).orElseThrow(() -> new NoSuchElementException("Company does not have a system payment configuration yet."));

        return systemPaymentConfigurationMapper.toResponseDTO(systemPaymentConfigurationModel);
    }

    @Override
    public SystemPaymentConfigurationResponseDTO getSystemPaymentConfigurationById(Long id) {
        SystemPaymentConfigurationModel systemPaymentConfigurationModel = systemPaymentConfigurationRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("System payment configuration not found"));

        return systemPaymentConfigurationMapper.toResponseDTO(systemPaymentConfigurationModel);
    }

    @Override
    public SystemPaymentConfigurationResponseDTO getSystemPaymentConfigurationByUUID(UUID uuid) {
        SystemPaymentConfigurationModel systemPaymentConfigurationModel = systemPaymentConfigurationRepositoryAdapter
                .findByUUID(uuid)
                .orElseThrow(() -> new NoSuchElementException("System payment configuration not found"));

        return systemPaymentConfigurationMapper.toResponseDTO(systemPaymentConfigurationModel);
    }

    @Override
    public SystemPaymentConfigurationResponseDTO createSystemPaymentConfiguration(SystemPaymentConfigurationCreateRequestDTO systemPaymentConfigurationResponseDTO) {
        CompanyModel companyModel = this.companyRepositoryAdapter
                .findById(systemPaymentConfigurationResponseDTO.getCompanyId())
                .orElseThrow(() -> new NoSuchElementException("Company not found"));

        if (systemPaymentConfigurationRepositoryAdapter.findByCompanyId(systemPaymentConfigurationResponseDTO.getCompanyId()).isPresent()) {
            throw new IllegalArgumentException("Company already has a system payment configuration");
        }

        SystemPaymentConfigurationModel systemPaymentConfigurationModel = new SystemPaymentConfigurationModel();

        systemPaymentConfigurationModel.setDayOfMonth(systemPaymentConfigurationResponseDTO.getDayOfMonth());
        systemPaymentConfigurationModel.setApplyDebtAfter(systemPaymentConfigurationResponseDTO.getApplyDebtAfter());
        systemPaymentConfigurationModel.setRequireOnCreateSale(systemPaymentConfigurationResponseDTO.getRequireOnCreateSale());
        systemPaymentConfigurationModel.setRequireForAllSales(systemPaymentConfigurationResponseDTO.getRequireForAllSales());
        systemPaymentConfigurationModel.setNewMonthAfterDate(systemPaymentConfigurationResponseDTO.getNewMonthAfterDate());
        systemPaymentConfigurationModel.setCompany(companyModel);

        SystemPaymentConfigurationModel savedSystemPaymentConfigurationModel = systemPaymentConfigurationRepositoryAdapter.save(systemPaymentConfigurationModel);

        return systemPaymentConfigurationMapper.toResponseDTO(savedSystemPaymentConfigurationModel);
    }

    @Override
    public SystemPaymentConfigurationResponseDTO updateSystemPaymentConfiguration(Long id, SystemPaymentConfigurationUpdateRequestDTO systemPaymentConfigurationResponseDTO) {
        SystemPaymentConfigurationModel systemPaymentConfigurationModel = systemPaymentConfigurationRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("System payment configuration not found"));

        if (systemPaymentConfigurationResponseDTO.getDayOfMonth() != null) {
            systemPaymentConfigurationModel.setDayOfMonth(systemPaymentConfigurationResponseDTO.getDayOfMonth());
        }
        if (systemPaymentConfigurationResponseDTO.getApplyDebtAfter() != null) {
            systemPaymentConfigurationModel.setApplyDebtAfter(systemPaymentConfigurationResponseDTO.getApplyDebtAfter());
        }
        if (systemPaymentConfigurationResponseDTO.getRequireOnCreateSale() != null) {
            systemPaymentConfigurationModel.setRequireOnCreateSale(systemPaymentConfigurationResponseDTO.getRequireOnCreateSale());
        }
        if (systemPaymentConfigurationResponseDTO.getRequireForAllSales() != null) {
            systemPaymentConfigurationModel.setRequireForAllSales(systemPaymentConfigurationResponseDTO.getRequireForAllSales());
        }

        SystemPaymentConfigurationModel savedSystemPaymentConfigurationModel = systemPaymentConfigurationRepositoryAdapter.save(systemPaymentConfigurationModel);

        return systemPaymentConfigurationMapper.toResponseDTO(savedSystemPaymentConfigurationModel);
    }

    @Override
    public void deleteSystemPaymentConfigurationById(Long id) {
        SystemPaymentConfigurationModel config = this.systemPaymentConfigurationRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("System payment configuration not found"));

        CompanyModel company = config.getCompany();
        if (company != null) {
            company.setSystemPaymentConfiguration(null); // desvincula da empresa
            this.companyRepositoryAdapter.save(company); // atualiza empresa para refletir essa desvinculação
        }

        this.systemPaymentConfigurationRepositoryAdapter.deleteById(id);
    }
}