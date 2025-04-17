package sales.sysconp.microservice.config.features.address.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.features.address.infrastructure.entities.AddressEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAAddressRepository extends JpaRepository<AddressEntity, Long> {
    Optional<AddressEntity> findByUuid(UUID uuid);

    List<AddressEntity> findByClientId(Long clientId);
}
