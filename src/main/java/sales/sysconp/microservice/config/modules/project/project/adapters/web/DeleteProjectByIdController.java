package sales.sysconp.microservice.config.modules.project.project.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.project.application.services.ProjectService;

@RestController
@RequestMapping("project")
public class DeleteProjectByIdController {
    private final ProjectService projectService;

    public DeleteProjectByIdController (ProjectService projectService) {
        this.projectService = projectService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteProjectById(
            @PathVariable("id") Long id
    ) {
        projectService.deleteProject(id);
    }
}
