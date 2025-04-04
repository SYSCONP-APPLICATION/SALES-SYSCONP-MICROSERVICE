package sales.sysconp.microservice.modules.project.project.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.project.application.dto.ProjectCreateRequestDTO;
import sales.sysconp.microservice.modules.project.project.application.dto.ProjectResponseDTO;
import sales.sysconp.microservice.modules.project.project.application.services.ProjectService;

@RestController
@RequestMapping("project")
public class CreateProjectController {
    private final ProjectService projectService;

    public CreateProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("create")
    public ProjectResponseDTO createProject(
            @RequestBody @Valid ProjectCreateRequestDTO projectCreateRequestDTO
    ) {
        return projectService.createProject(projectCreateRequestDTO);
    }
}