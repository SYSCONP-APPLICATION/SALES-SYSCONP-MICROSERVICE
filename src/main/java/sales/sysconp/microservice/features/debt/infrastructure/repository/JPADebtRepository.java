package sales.sysconp.microservice.features.debt.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.features.debt.infrastructure.entities.DebtEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPADebtRepository extends JpaRepository<DebtEntity, Long> {
    Optional<DebtEntity> findByUuid(UUID uuid);

    List<DebtEntity> findByInstallment_Sale_Id(Long saleId);

    List<DebtEntity> findByInstallment_Sale_Client_Id(Long clientId);

    Optional<DebtEntity> findByInstallment_Id(Long installmentId);
}
