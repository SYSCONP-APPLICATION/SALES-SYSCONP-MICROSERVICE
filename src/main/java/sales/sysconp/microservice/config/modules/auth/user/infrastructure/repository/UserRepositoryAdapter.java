package sales.sysconp.microservice.config.modules.auth.user.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.modules.auth.user.application.ports.out.UserRepositoryOutPort;
import sales.sysconp.microservice.modules.auth.user.domain.mappers.UserMapper;
import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;
import sales.sysconp.microservice.modules.auth.user.infrastructure.repository.JPAUserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryAdapter implements UserRepositoryOutPort {
    private final sales.sysconp.microservice.modules.auth.user.infrastructure.repository.JPAUserRepository jpaRepository;
    private final UserMapper userMapper;

    public UserRepositoryAdapter(JPAUserRepository jpaRepository, UserMapper userMapper) {
        this.jpaRepository = jpaRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserModel> findAll() {
        return this.jpaRepository
                .findAll()
                .stream()
                .map(userMapper::toModel)
                .toList();
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        return this.jpaRepository
                .findById(id)
                .map(userMapper::toModel);
    }

    @Override
    public Optional<UserModel> findByUUID(UUID uuid) {
        return this.jpaRepository
                .findByUuid(uuid)
                .map(userMapper::toModel);
    }

    @Override
    public Optional<UserModel> findByIdAndCompanyId(Long id, Long companyId) {
        return this.jpaRepository
            .findByIdAndCompanyId(id, companyId)
            .map(userMapper::toModel);
    }

    @Override
    public UserModel save(UserModel model) {
        UserEntity savedModel = this.jpaRepository.save(userMapper.toEntity(model));
        return userMapper.toModel(savedModel);
    }

    @Override
    public void deleteById(Long id) {
        this.jpaRepository.deleteById(id);
    }


    @Override
    public List<UserModel> findByCompanyId(Long companyId) {
        return this.jpaRepository
                .findByCompanyId(companyId)
                .stream()
                .map(userMapper::toModel)
                .toList();
    }
}
