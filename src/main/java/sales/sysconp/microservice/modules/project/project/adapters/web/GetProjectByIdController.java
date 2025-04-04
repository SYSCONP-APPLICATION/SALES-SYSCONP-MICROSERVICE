package sales.sysconp.microservice.modules.project.project.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.project.application.dto.ProjectResponseDTO;
import sales.sysconp.microservice.modules.project.project.application.services.ProjectService;

@RestController
@RequestMapping("project")
public class GetProjectByIdController {
    private final ProjectService projectService;

    public GetProjectByIdController (ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("get/{id}")
    public ProjectResponseDTO getProjectById(
            @PathVariable("id") Long id
    ) {
        return projectService.findProjectById(id);
    }
}
