package sales.sysconp.microservice.modules.project.unity.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityResponseDTO;
import sales.sysconp.microservice.modules.project.unity.application.services.UnityService;

import java.util.UUID;

@RestController
@RequestMapping("unity")
public class GetUnityByUUIDController {
    private final UnityService unityService;

    public GetUnityByUUIDController(UnityService unityService) {
        this.unityService = unityService;
    }

    @GetMapping("uuid/{uuid}")
    public UnityResponseDTO getUnityByUUID(
            @PathVariable("uuid") UUID uuid
    ) {
        return this.unityService.getUnityByUuid(uuid);
    }
}