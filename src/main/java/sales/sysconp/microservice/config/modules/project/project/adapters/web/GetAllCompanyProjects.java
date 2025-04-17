package sales.sysconp.microservice.config.modules.project.project.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.project.application.dto.ProjectResponseDTO;
import sales.sysconp.microservice.modules.project.project.application.services.ProjectService;

import java.util.List;

@RestController
@RequestMapping("project")
public class GetAllCompanyProjects {
    private final ProjectService projectService;

    public GetAllCompanyProjects (ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("company/{id}/all")
    public List<ProjectResponseDTO> getAllCompanyProjects(@PathVariable("id") Long companyId) {
        return projectService.getAllCompanyProjects(companyId);
    }
}
