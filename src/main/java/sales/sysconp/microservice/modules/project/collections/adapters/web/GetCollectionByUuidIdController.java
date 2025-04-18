package sales.sysconp.microservice.modules.project.collections.adapters.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.sysconp.microservice.modules.project.collections.application.dto.CollectionResponseDTO;
import sales.sysconp.microservice.modules.project.collections.application.services.CollectionService;

import java.util.UUID;

@RestController
@RequestMapping("collection")
public class GetCollectionByUuidIdController {
    private final CollectionService collectionService;

    public GetCollectionByUuidIdController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping("uuid/{uuid}")
    public CollectionResponseDTO getCollectionByUuid(@PathVariable("uuid") UUID uuid) {
        return this.collectionService.getCollectionByUuid(uuid);
    }
}