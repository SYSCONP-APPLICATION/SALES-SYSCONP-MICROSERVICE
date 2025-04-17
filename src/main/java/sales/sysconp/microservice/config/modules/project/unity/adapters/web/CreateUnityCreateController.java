package sales.sysconp.microservice.config.modules.project.unity.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityCreateRequestDTO;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityResponseDTO;
import sales.sysconp.microservice.modules.project.unity.application.services.UnityService;

@RestController
@RequestMapping("unity")
public class CreateUnityCreateController {
    private final UnityService unityService;

    public CreateUnityCreateController(UnityService unityService) {
        this.unityService = unityService;
    }

    @PostMapping("create")
    public UnityResponseDTO createUnity(
            @RequestBody @Valid UnityCreateRequestDTO unityCreateRequestDTO
    ) {
        return unityService.createUnity(unityCreateRequestDTO);
    }
}