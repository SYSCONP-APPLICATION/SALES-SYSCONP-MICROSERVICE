package sales.sysconp.microservice.modules.auth.user.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserResponseDTO;
import sales.sysconp.microservice.modules.auth.user.application.services.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
public class GetAllUsersController {
    private final UserService userService;

    public GetAllUsersController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }
}