package sales.sysconp.microservice.modules.project.collections.adapters.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionCreateRequestDTO;
import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionResponseDTO;
import sales.sysconp.microservice.modules.project.collections.application.services.CollectionService;

@RestController
@RequestMapping("collection")
public class CreateCollectionController {

    private final CollectionService collectionService;

    public CreateCollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @PostMapping("create")
    public CollectionResponseDTO createCollection(
            @Valid @RequestBody CollectionCreateRequestDTO collectionCreateRequestDTO
    ) {
        return this.collectionService.createCollection(collectionCreateRequestDTO);
    }
}