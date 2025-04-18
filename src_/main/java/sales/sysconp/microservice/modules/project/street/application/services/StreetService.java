package sales.sysconp.microservice.modules.project.street.application.services;

import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;
import sales.sysconp.microservice.modules.project.project.infrastructure.repository.ProjectRepositoryAdapter;
import sales.sysconp.microservice.modules.project.street.application.dto.StreetCreateRequestDTO;
import sales.sysconp.microservice.modules.project.street.application.dto.StreetResponseDTO;
import sales.sysconp.microservice.modules.project.street.application.dto.StreetUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.street.application.ports.in.StreetServiceInPort;
import sales.sysconp.microservice.modules.project.street.domain.mappers.StreetMapper;
import sales.sysconp.microservice.modules.project.street.domain.models.StreetModel;
import sales.sysconp.microservice.modules.project.street.infrastructure.repository.StreetRepositoryAdapter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class StreetService implements StreetServiceInPort {
    private final StreetRepositoryAdapter streetRepositoryAdapter;
    private final ProjectRepositoryAdapter projectRepositoryAdapter;
    private final StreetMapper streetMapper;

    public StreetService(StreetRepositoryAdapter streetRepositoryAdapter, ProjectRepositoryAdapter projectRepositoryAdapter, StreetMapper streetMapper) {
        this.streetRepositoryAdapter = streetRepositoryAdapter;
        this.projectRepositoryAdapter = projectRepositoryAdapter;
        this.streetMapper = streetMapper;
    }

    @Override
    public List<StreetResponseDTO> getAllStreetsByProjectId(Long projectId) {
        this.projectRepositoryAdapter.findById(projectId)
                .orElseThrow(() -> new NoSuchElementException("Project not found!"));

        return this.streetRepositoryAdapter
                .findAllByProjectId(projectId)
                .stream()
                .map(this.streetMapper::toResponseDTO)
                .toList();
    }

    @Override
    public StreetResponseDTO getStreetById(Long streetId) {
        return this.streetRepositoryAdapter
                .findById(streetId)
                .map(this.streetMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Street not found!"));
    }

    @Override
    public StreetResponseDTO getStreetByUuid(UUID uuid) {
        return this.streetRepositoryAdapter
                .findByUuid(uuid)
                .map(this.streetMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Street not found!"));
    }

    @Override
    public StreetResponseDTO createStreet(StreetCreateRequestDTO streetCreateRequestDTO) {
        Optional<StreetModel> streetById = this.streetRepositoryAdapter
                .findByIdAndProjectId(streetCreateRequestDTO.getId(), streetCreateRequestDTO.getProjectId());

        if (streetById.isPresent()) {
            throw new EntityExistsException("Ja existe uma rua com esse id num projecto");
        }

        Optional<StreetModel> streetByUUID = this.streetRepositoryAdapter.findByUuidAndProjectId(streetCreateRequestDTO.getUuid(), streetCreateRequestDTO.getProjectId());

        if (streetByUUID.isPresent()) {
            throw new EntityExistsException("Ja existe uma rua com esse uuid num projecto");
        }

        Optional<StreetModel> streetByName = this.streetRepositoryAdapter.findByNameAndProjectId(streetCreateRequestDTO.getName(), streetCreateRequestDTO.getProjectId());

        if (streetByName.isPresent()) {
            throw new EntityExistsException("Ja existe uma rua com esse nome num projecto");
        }

        ProjectModel project = this.projectRepositoryAdapter
                .findById(streetCreateRequestDTO.getProjectId())
                .orElseThrow(() -> new NoSuchElementException("Project not found!"));

        StreetModel streetModel = new StreetModel();

        streetModel.setId(streetCreateRequestDTO.getId());
        streetModel.setUuid(streetCreateRequestDTO.getUuid());
        streetModel.setName(streetCreateRequestDTO.getName());
        streetModel.setProject(project);
        streetModel.setCreatedAt(streetCreateRequestDTO.getCreatedAt());
        streetModel.setUpdatedAt(streetCreateRequestDTO.getUpdatedAt());

        return this.streetMapper.toResponseDTO(this.streetRepositoryAdapter.save(streetModel));
    }

    @Override
    public StreetResponseDTO updateStreet(Long id, StreetUpdateRequestDTO streetUpdateRequestDTO) {
        StreetModel streetModel = this.streetRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Street not found!"));

        Optional<StreetModel> streetModelByNameAndProjectId = this.streetRepositoryAdapter
                .findByNameAndProjectId(streetUpdateRequestDTO.getName(), streetModel.getProject().getId());

        if (streetModelByNameAndProjectId.isPresent() && !streetModelByNameAndProjectId.get().getId().equals(streetModel.getId())) {
            throw new EntityExistsException("Ja existe uma rua com esse nome num projecto");
        }

        streetModel.setName(streetUpdateRequestDTO.getName());
        streetModel.setUpdatedAt(streetUpdateRequestDTO.getUpdatedAt());

        return this.streetMapper.toResponseDTO(this.streetRepositoryAdapter.save(streetModel));
    }

    @Override
    public void deleteStreet(Long streetId) {
        this.streetRepositoryAdapter.findById(streetId)
                .orElseThrow(() -> new NoSuchElementException("Street not found!"));

        this.streetRepositoryAdapter.delete(streetId);
    }
}