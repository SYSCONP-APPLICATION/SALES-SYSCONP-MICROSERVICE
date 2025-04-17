package sales.sysconp.microservice.config.modules.auth.user.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserResponseDTO;
import sales.sysconp.microservice.modules.auth.user.application.services.UserService;

@RestController
@RequestMapping("user")
public class GetUserByIdController {
    private final UserService userService;

    public GetUserByIdController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("get/{id}")
    public UserResponseDTO findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }
}