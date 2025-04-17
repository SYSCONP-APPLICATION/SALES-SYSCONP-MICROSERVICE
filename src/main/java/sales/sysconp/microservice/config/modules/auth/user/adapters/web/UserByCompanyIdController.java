package sales.sysconp.microservice.config.modules.auth.user.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserResponseDTO;
import sales.sysconp.microservice.modules.auth.user.application.services.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserByCompanyIdController {
    private final UserService userService;

    public UserByCompanyIdController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("company/{id}/all")
    public List<UserResponseDTO> getUsersByCompany(
            @PathVariable("id") Long id
    ) {
        return userService.getUsersByCompany(id);
    }
}
