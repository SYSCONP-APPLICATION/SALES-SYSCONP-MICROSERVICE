package sales.sysconp.microservice.config.modules.project.compartment.application.ports.out;

import sales.sysconp.microservice.modules.project.compartment.domain.models.CompartmentModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompartmentRepositoryOutPort {
    List<CompartmentModel> findByUnityId(Long unityId);

    Optional<CompartmentModel> findById(Long id);

    Optional<CompartmentModel> findByUuid(UUID uuid);

    CompartmentModel save(CompartmentModel compartmentModel);

    void delete(Long id);
}
