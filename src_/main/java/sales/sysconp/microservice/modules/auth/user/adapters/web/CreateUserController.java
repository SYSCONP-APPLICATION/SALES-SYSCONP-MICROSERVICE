package sales.sysconp.microservice.modules.auth.user.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserCreateRequestDTO;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserResponseDTO;
import sales.sysconp.microservice.modules.auth.user.application.services.UserService;

@RestController
@RequestMapping("user")
public class CreateUserController {
    private final UserService userService;

    public CreateUserController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    public UserResponseDTO createUser(
            @RequestBody @Valid UserCreateRequestDTO userCreateRequestDTO
    ) {
        return userService.createUser(userCreateRequestDTO);
    }
}