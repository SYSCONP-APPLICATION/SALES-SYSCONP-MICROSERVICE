package sales.sysconp.microservice.featuresd.contact_type.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.features.contact_type.infrastructure.entities.ContactTypeEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JPAContactTypeRepository extends JpaRepository<ContactTypeEntity, Long> {
    Optional<ContactTypeEntity> findByUuid(UUID uuid);
    Optional<ContactTypeEntity> findByName(String name);
}
