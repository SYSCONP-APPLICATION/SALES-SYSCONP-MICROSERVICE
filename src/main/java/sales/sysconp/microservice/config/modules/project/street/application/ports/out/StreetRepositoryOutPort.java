package sales.sysconp.microservice.config.modules.project.street.application.ports.out;

import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;
import sales.sysconp.microservice.modules.project.street.domain.models.StreetModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StreetRepositoryOutPort {
    List<StreetModel> findAllByProjectId(Long projectId);

    Optional<StreetModel> findById(Long id);

    Optional<StreetModel> findByUuid(UUID uuid);

    Optional<StreetModel> findByIdAndProjectId(Long id, Long projectId);

    Optional<StreetModel> findByUuidAndProjectId(UUID uuid, Long projectId);

    Optional<StreetModel> findByNameAndProjectId(String name, Long projectId);

    StreetModel save(StreetModel streetModel);

    void delete(Long streetId);
}