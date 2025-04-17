package sales.sysconp.microservice.config.modules.project.collections.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionResponseDTO;
import sales.sysconp.microservice.modules.project.collections.application.services.CollectionService;

import java.util.List;

@RestController
@RequestMapping("collection")
public class GetCollectionByProjectIdController {
    private final CollectionService collectionService;

    public GetCollectionByProjectIdController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping("project/{projectId}/all")
    public List<CollectionResponseDTO> getCollectionsByProjectId(
            @PathVariable Long projectId
    ) {
        return collectionService.getCollectionsByProjectId(projectId);
    }
}