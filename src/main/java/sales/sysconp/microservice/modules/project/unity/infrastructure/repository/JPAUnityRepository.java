package sales.sysconp.microservice.modules.project.unity.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.modules.project.unity.infrastructure.entities.UnityEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPAUnityRepository extends JpaRepository<UnityEntity, Long> {
    Optional<UnityEntity> findByIdAndPropertyId(Long id, Long propertyId);

    Optional<UnityEntity> findByUuid(UUID uuid);

    Optional<UnityEntity> findByUuidAndPropertyId(UUID uuid, Long propertyId);

    List<UnityEntity> findByPropertyId(Long propertyId);
}
