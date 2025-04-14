package sales.sysconp.microservice.modules.project.unity.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.project.unity.application.ports.in.UnityServiceInPort;

@RestController
@RequestMapping("unity")
public class DeleteUnityByIdController {
    private final UnityServiceInPort unityServiceInPort;

    public DeleteUnityByIdController(UnityServiceInPort unityServiceInPort) {
        this.unityServiceInPort = unityServiceInPort;
    }

    @DeleteMapping("delete/{id}")
    public void getUnityById(
            @PathVariable Long id
    ) {
        unityServiceInPort.deleteUnity(id);
    }
}