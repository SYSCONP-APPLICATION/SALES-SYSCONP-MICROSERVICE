package sales.sysconp.microservice.features.contact.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.features.contact.infrastructure.entities.ContactEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAContactRepository extends JpaRepository<ContactEntity, Long> {
    List<ContactEntity> findAllByCompanyId(Long companyId);

    Optional<ContactEntity> findByUuid(UUID uuid);
}
