package sales.sysconp.microservice.config.modules.project.collections.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionResponseDTO;
import sales.sysconp.microservice.modules.project.collections.application.services.CollectionService;

@RestController
@RequestMapping("collection")
public class GetCollectionByIdController {
    private final CollectionService collectionService;

    public GetCollectionByIdController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping("get/{id}")
    public CollectionResponseDTO getCollectionById(
            @PathVariable Long id
    ) {
        return this.collectionService.getCollectionById(id);
    }
}