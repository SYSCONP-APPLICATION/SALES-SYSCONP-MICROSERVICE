package sales.sysconp.microservice.config.modules.project.collections.adapters.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.collections.application.services.CollectionService;

@RestController
@RequestMapping("collection")
public class DeleteCollectionController {
    private final CollectionService collectionService;

    public DeleteCollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @DeleteMapping("delete/{id}")
    public void deleteCollection(
            @PathVariable Long id
    ) {
        collectionService.deleteCollectionById(id);
    }
}