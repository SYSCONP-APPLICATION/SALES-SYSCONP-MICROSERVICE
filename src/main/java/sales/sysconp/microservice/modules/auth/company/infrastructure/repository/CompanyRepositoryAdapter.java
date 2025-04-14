package sales.sysconp.microservice.modules.auth.company.infrastructure.repository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.modules.auth.company.application.ports.out.CompanyRepositoryOutPort;
import sales.sysconp.microservice.modules.auth.company.domain.mapper.CompanyMapper;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CompanyRepositoryAdapter implements CompanyRepositoryOutPort {
    private final JPACompanyRepository jpaRepository;
    private final CompanyMapper companyMapper;

    public CompanyRepositoryAdapter(JPACompanyRepository jpaRepository, CompanyMapper companyMapper) {
        this.jpaRepository = jpaRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public List<CompanyModel> findAll() {
        return this.jpaRepository
                .findAll()
                .stream()
                .map(companyMapper::toModel)
                .toList();
    }

    @Override
    public Optional<CompanyModel> findById(long id) {
        return this.jpaRepository
                .findById(id)
                .map(companyMapper::toModel);
    }

    @Override
    public Optional<CompanyModel> findByUUID(UUID uuid) {
        return this.jpaRepository
                .findByUuid(uuid)
                .map(companyMapper::toModel);
    }

    @Override
    public Optional<CompanyModel> findByBrandName(String brandName) {
        return this.jpaRepository
                .findByBrandName(brandName)
                .map(companyMapper::toModel);
    }

    @Override
    public Optional<CompanyModel> findByCommercialName(String commercialName) {
        return this.jpaRepository
                .findByCommercialName(commercialName)
                .map(companyMapper::toModel);
    }

    @Override
    public CompanyModel save(CompanyModel model) {
        CompanyEntity savedModel = this.jpaRepository.save(companyMapper.toEntity(model));
        return companyMapper.toModel(savedModel);
    }

    @Override
    public void deleteById(long id) {
        this.jpaRepository.deleteById(id);
    }
}
