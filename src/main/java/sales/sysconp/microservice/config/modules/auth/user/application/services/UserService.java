package sales.sysconp.microservice.config.modules.auth.user.application.services;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.modules.auth.company.application.services.CompanyService;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.repository.CompanyRepositoryAdapter;
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
    private final CompanyRepositoryAdapter companyRepositoryAdapter;
    private final UserMapper userMapper;

    public UserService(UserRepositoryAdapter userRepositoryAdapter, UserMapper userMapper, CompanyRepositoryAdapter companyRepositoryAdapter) {
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.userMapper = userMapper;
        this.companyRepositoryAdapter = companyRepositoryAdapter;
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
                 .orElseThrow(() -> new NoSuchElementException("Usuario nao encontrado!"));

         return userMapper.toResponseDTO(userModel);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserUpdateRequestDTO userUpdateRequestDTO) {
        UserModel userModel = this.userRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado!"));

        if (userUpdateRequestDTO.getName() != null) {
            userModel.setName(userUpdateRequestDTO.getName());
        }
        if (userUpdateRequestDTO.getUpdatedAt() != null) {
            userModel.setUpdatedAt(userUpdateRequestDTO.getUpdatedAt());
        }

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

        CompanyModel company = this.companyRepositoryAdapter
                .findById(userCreateRequestDTO.getCompanyId())
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada!"));

        UserModel userModel = new UserModel();

        userModel.setId(userCreateRequestDTO.getId());
        userModel.setUuid(userCreateRequestDTO.getUuid());
        userModel.setName(userCreateRequestDTO.getName());
        userModel.setCreatedAt(userCreateRequestDTO.getCreatedAt());
        userModel.setUpdatedAt(userCreateRequestDTO.getUpdatedAt());
        userModel.setCompany(company);

        UserModel savedUserModel = userRepositoryAdapter.save(userModel);
        return userMapper.toResponseDTO(savedUserModel);
    }

    @Override
    public List<UserResponseDTO> getUsersByCompany(Long id) {
        this.companyRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa nao encontrada!"));

        List<UserModel> users = this.userRepositoryAdapter.findByCompanyId(id);

        return users
            .stream()
            .map(userMapper::toResponseDTO)
            .toList();
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuario nao encontrado!"));

        this.userRepositoryAdapter.deleteById(id);
    }
}
