package sales.sysconp.microservice.features.installment.application.ports.out;

import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InstallmentRepositoryOutPort {
    List<InstallmentModel> findAllBySaleId(Long saleId);

    Optional<InstallmentModel> findById(Long id);

    Optional<InstallmentModel> findByUUID(UUID uuid);

    InstallmentModel save(InstallmentModel installmentModel);

    List<InstallmentModel> saveAll(List<InstallmentModel> installmentModels);

    List<InstallmentModel> findBySaleUuid(UUID saleUuid);

    void deleteById(Long id);
}