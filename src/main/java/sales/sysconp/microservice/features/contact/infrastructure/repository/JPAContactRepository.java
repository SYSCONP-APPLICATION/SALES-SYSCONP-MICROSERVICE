package sales.sysconp.microservice.features.contact.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.features.contact.infrastructure.entities.ContactEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAContactRepository extends JpaRepository<ContactEntity, Long> {
    List<ContactEntity> findAllByClient_Company_Id(Long companyId);

    Optional<ContactEntity> findByUuid(UUID uuid);

    List<ContactEntity> findAllByClientId(Long clientId);

    Optional<ContactEntity> findByValueAndClientIdAndContactTypeId(String value, Long clientId, Long contactTypeId);
}
