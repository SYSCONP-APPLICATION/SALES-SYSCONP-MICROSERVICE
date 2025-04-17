package sales.sysconp.microservice.config.features.sale.application.ports.out;

import sales.sysconp.microservice.features.sale.domain.models.SaleModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SaleRepositoryOutPort {
    List<SaleModel> findAllByCompanyId(Long companyId);

    Optional<SaleModel> findById(Long id);

    Optional<SaleModel> findByUUID(UUID uuid);

    SaleModel save(SaleModel saleModel);

    void deleteById(Long id);
}