package sales.sysconp.microservice.config.modules.project.collections.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionResponseDTO;
import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.collections.application.services.CollectionService;

@RestController
@RequestMapping("collection")
public class UpdateCollectionController {

    private final CollectionService collectionService;

    public UpdateCollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @PutMapping("update/{id}")
    public CollectionResponseDTO updateCollection(
            @PathVariable Long id,
            @RequestBody @Valid CollectionUpdateRequestDTO collectionUpdateRequestDTO
    ) {
        return collectionService.updateCollection(id, collectionUpdateRequestDTO);
    }
}