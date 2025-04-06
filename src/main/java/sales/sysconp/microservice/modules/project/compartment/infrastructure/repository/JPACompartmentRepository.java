package sales.sysconp.microservice.modules.project.compartment.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.modules.project.compartment.infrastructure.entities.CompartmentEntity;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface JPACompartmentRepository extends JpaRepository<CompartmentEntity, Long> {
    Optional<CompartmentEntity> findByUuid(UUID uuid);

    List<CompartmentEntity> findByUnityId(Long unityId);
}
