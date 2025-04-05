package sales.sysconp.microservice.modules.project.unity.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.unity.application.dto.UnityResponseDTO;
import sales.sysconp.microservice.modules.project.unity.application.ports.in.UnityServiceInPort;

import java.util.List;

@RestController
@RequestMapping("unity")
public class GetUnitiesByPropertyIdController {
    private final UnityServiceInPort unityServiceInPort;

    public GetUnitiesByPropertyIdController(UnityServiceInPort unityServiceInPort) {
        this.unityServiceInPort = unityServiceInPort;
    }

    @GetMapping("property/{id}/all")
    public List<UnityResponseDTO> getUnitiesByPropertyId(
            @PathVariable Long id
    ) {
        return unityServiceInPort.getUnitiesByPropertyId(id);
    }
}