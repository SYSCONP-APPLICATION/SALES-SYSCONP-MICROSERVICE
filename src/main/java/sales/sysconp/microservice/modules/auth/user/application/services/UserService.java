package sales.sysconp.microservice.modules.auth.user.application.services;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserCreateRequestDTO;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserResponseDTO;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserUpdateRequestDTO;
import sales.sysconp.microservice.modules.auth.user.application.ports.in.UserServiceInPort;
import sales.sysconp.microservice.modules.auth.user.domain.mappers.UserMapper;
import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;
import sales.sysconp.microservice.modules.auth.user.infrastructure.repository.UserRepositoryAdapter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService implements UserServiceInPort {
    private final UserRepositoryAdapter userRepositoryAdapter;
    private final UserMapper userMapper;

    public UserService(UserRepositoryAdapter userRepositoryAdapter, UserMapper userMapper) {
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return this.userRepositoryAdapter
                .findAll()
                .stream()
                .map(userMapper::toResponseDTO)
                .toList();
    }

    @Override
    public UserResponseDTO findUserById(Long id) {
         UserModel userModel = this.userRepositoryAdapter
                 .findById(id)
                 .orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado!"));

         return userMapper.toResponseDTO(userModel);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserUpdateRequestDTO userUpdateRequestDTO) {
        UserModel userModel = this.userRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado!"));

        userModel.setName(userUpdateRequestDTO.getName());
        userModel.setUpdatedAt(userUpdateRequestDTO.getUpdatedAt());

        return userMapper.toResponseDTO(this.userRepositoryAdapter.save(userModel));
    }

    @Override
    public UserResponseDTO createUser(UserCreateRequestDTO userCreateRequestDTO) {
        Optional<UserModel> userById = this.userRepositoryAdapter.findById(userCreateRequestDTO.getId());

        if (userById.isPresent()) {
            throw new EntityExistsException("Já existe um usuário com esse id!");
        }

        Optional<UserModel> userByUuid = this.userRepositoryAdapter.findByUUID(userCreateRequestDTO.getUuid());

        if (userByUuid.isPresent()) {
            throw new EntityExistsException("Já existe um usuário com esse uuid!");
        }

        UserModel userModel = new UserModel();

        userModel.setId(userCreateRequestDTO.getId());
        userModel.setUuid(userCreateRequestDTO.getUuid());
        userModel.setName(userCreateRequestDTO.getName());
        userModel.setCreatedAt(userCreateRequestDTO.getCreatedAt());
        userModel.setUpdatedAt(userCreateRequestDTO.getUpdatedAt());

        UserModel savedUserModel = userRepositoryAdapter.save(userModel);
        return userMapper.toResponseDTO(savedUserModel);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuario nao encontrado!"));

        this.userRepositoryAdapter.deleteById(id);
    }
}
