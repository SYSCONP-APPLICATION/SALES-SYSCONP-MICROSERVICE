package sales.sysconp.microservice.features.debt.application.ports.out;

import sales.sysconp.microservice.features.debt.domain.models.DebtModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DebtRepositoryOutPort {
    Optional<DebtModel> findById(Long id);

    Optional<DebtModel> findByUUID(UUID uuid);

    List<DebtModel> findAllBySaleId(Long saleId);

    List<DebtModel> findAllByClientId(Long clientId);

    DebtModel save(DebtModel debtModel);

    void deleteById(Long id);
}