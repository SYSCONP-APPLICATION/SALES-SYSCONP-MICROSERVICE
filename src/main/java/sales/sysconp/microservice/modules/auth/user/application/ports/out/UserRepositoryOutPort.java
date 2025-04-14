package sales.sysconp.microservice.modules.auth.user.application.ports.out;

import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryOutPort {
    List<UserModel> findAll();

    Optional<UserModel> findById(Long id);

    Optional<UserModel> findByUUID(UUID uuid);

    Optional<UserModel> findByIdAndCompanyId(Long id, Long companyId);

    UserModel save(UserModel model);

    List<UserModel> findByCompanyId(Long companyId);

    void deleteById(Long id);
}