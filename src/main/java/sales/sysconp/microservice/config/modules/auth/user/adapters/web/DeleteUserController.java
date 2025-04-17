package sales.sysconp.microservice.config.modules.auth.user.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.auth.user.application.services.UserService;

@RestController
@RequestMapping("user")
public class DeleteUserController {
    private final UserService userService;

    public DeleteUserController (UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
