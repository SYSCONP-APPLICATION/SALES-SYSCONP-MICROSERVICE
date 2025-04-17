package sales.sysconp.microservice.config.modules.project.project.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.project.application.dto.ProjectResponseDTO;
import sales.sysconp.microservice.modules.project.project.application.services.ProjectService;

import java.util.UUID;

@RestController
@RequestMapping("project")
public class GetProjectByUUIDController {
    private final ProjectService projectService;

    public GetProjectByUUIDController (ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("uuid/{uuid}")
    public ProjectResponseDTO getProjectByUUID(
            @PathVariable("uuid") UUID uuid
    ) {
        return projectService.findProjectByUUID(uuid);
    }
}
