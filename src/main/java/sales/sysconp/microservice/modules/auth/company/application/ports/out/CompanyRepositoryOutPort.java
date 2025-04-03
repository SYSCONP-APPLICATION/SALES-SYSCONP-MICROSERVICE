package sales.sysconp.microservice.modules.auth.company.application.ports.out;

import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepositoryOutPort {
    List<CompanyModel> findAll();

    Optional<CompanyModel> findById(long id);

    Optional<CompanyModel> findByUUID(UUID uuid);

    Optional<CompanyModel> findByBrandName(String brandName);

    Optional<CompanyModel> findByCommercialName(String commercialName);

    CompanyModel save(CompanyModel model);

    void deleteById(long id);
}
