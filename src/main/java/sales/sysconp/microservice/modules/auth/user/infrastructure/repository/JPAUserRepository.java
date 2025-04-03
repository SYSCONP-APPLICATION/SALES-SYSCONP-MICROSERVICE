package sales.sysconp.microservice.modules.auth.user.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface JPAUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUuid(UUID uuid);
}