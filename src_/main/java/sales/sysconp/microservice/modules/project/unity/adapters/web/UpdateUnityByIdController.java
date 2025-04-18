package sales.sysconp.microservice.modules.project.unity.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityResponseDTO;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.unity.application.ports.in.UnityServiceInPort;

@RestController
@RequestMapping("unity")
public class UpdateUnityByIdController {
    private final UnityServiceInPort unityServiceInPort;

    public UpdateUnityByIdController(UnityServiceInPort unityServiceInPort) {
        this.unityServiceInPort = unityServiceInPort;
    }

    @PutMapping("update/{id}")
    public UnityResponseDTO updateUnity(
            @PathVariable Long id,
            @RequestBody UnityUpdateRequestDTO unityCreateRequestDTO
    ) {
        return unityServiceInPort.updateUnity(id, unityCreateRequestDTO);
    }
}