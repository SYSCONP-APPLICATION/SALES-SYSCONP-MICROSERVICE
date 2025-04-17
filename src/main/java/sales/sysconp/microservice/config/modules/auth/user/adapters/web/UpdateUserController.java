package sales.sysconp.microservice.config.modules.auth.user.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserResponseDTO;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserUpdateRequestDTO;
import sales.sysconp.microservice.modules.auth.user.application.services.UserService;

@RestController
@RequestMapping("user")
public class UpdateUserController {
    private final UserService userService;

    public UpdateUserController (UserService userService) {
        this.userService = userService;
    }

    @PutMapping("update/{id}")
    public UserResponseDTO updateUser(
            @PathVariable Long id,
            @RequestBody @Valid UserUpdateRequestDTO userUpdateRequestDTO
    ) {
        return userService.updateUser(id, userUpdateRequestDTO);
    }
}
