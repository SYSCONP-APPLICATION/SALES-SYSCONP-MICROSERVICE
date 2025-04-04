package sales.sysconp.microservice.modules.project.project.adapters.web;

import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.project.project.application.dto.ProjectResponseDTO;
import sales.sysconp.microservice.modules.project.project.application.dto.ProjectUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.project.application.services.ProjectService;

@RestController
@RequestMapping("project")
public class UpdateProjectController {
    private final ProjectService projectService;

    public UpdateProjectController (ProjectService projectService) {
        this.projectService = projectService;
    }

    @PutMapping("update/{id}")
    public ProjectResponseDTO updateProject(
            @PathVariable("id") Long id,
            @RequestBody ProjectUpdateRequestDTO projectUpdateRequestDTO
    ) {
        return projectService.updateProject(id, projectUpdateRequestDTO);
    }
}