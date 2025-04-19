package sales.sysconp.microservice.features.installment.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAInstallmentRepository extends JpaRepository<InstallmentEntity, Long> {
    List<InstallmentEntity> findBySaleId(Long saleId);

    List<InstallmentEntity> findBySaleUuid(UUID saleUuid);

    Optional<InstallmentEntity> findByUuid(UUID uuid);

    List<InstallmentEntity> findBySaleIdAndPaidAtIsNull(Long saleId);

    @Modifying
    @Query("UPDATE InstallmentEntity i SET i.paidAt = :paidAt WHERE i.id = :id")
    void updatePaidAt(@Param("id") Long id, @Param("paidAt") LocalDateTime paidAt);
}
