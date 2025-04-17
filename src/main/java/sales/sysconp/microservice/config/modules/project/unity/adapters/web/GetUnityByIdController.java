package sales.sysconp.microservice.config.modules.project.unity.adapters.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.unity.application.ports.in.UnityServiceInPort;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityResponseDTO;

@RestController
@RequestMapping("unity")
public class GetUnityByIdController {
    private final UnityServiceInPort unityServiceInPort;

    public GetUnityByIdController(UnityServiceInPort unityServiceInPort) {
        this.unityServiceInPort = unityServiceInPort;
    }

    @GetMapping("get/{id}")
    public UnityResponseDTO getUnityById(
            @PathVariable Long id
    ) {
        return unityServiceInPort.getUnityById(id);
    }
}