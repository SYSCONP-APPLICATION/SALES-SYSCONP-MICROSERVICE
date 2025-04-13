package sales.sysconp.microservice.features.client.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAClientRepository extends JpaRepository<ClientEntity, Long> {
    List<ClientEntity> findByCompanyId(Long companyId);

    Optional<ClientEntity> findByUuid(UUID uuid);
}
