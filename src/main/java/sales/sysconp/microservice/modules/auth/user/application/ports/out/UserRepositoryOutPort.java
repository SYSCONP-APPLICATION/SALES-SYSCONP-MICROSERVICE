package sales.sysconp.microservice.modules.auth.user.application.ports.out;

import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryOutPort {
    List<UserModel> findAll();

    Optional<UserModel> findById(long id);

    Optional<UserModel> findByUUID(UUID uuid);

    UserModel save(UserModel model);

    void deleteById(long id);
}