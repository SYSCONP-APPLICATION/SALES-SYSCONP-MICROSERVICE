package sales.sysconp.microservice.modules.auth.user.application.ports.in;

import sales.sysconp.microservice.modules.auth.user.application.dto.UserCreateRequestDTO;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserResponseDTO;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserUpdateRequestDTO;

import java.util.List;

public interface UserServiceInPort {
    List<UserResponseDTO> getAllUsers();

    UserResponseDTO findUserById(Long id);

    UserResponseDTO updateUser(Long id, UserUpdateRequestDTO userUpdateRequestDTO);

    UserResponseDTO createUser(UserCreateRequestDTO userCreateRequestDTO);

    void deleteUser(Long id);
}