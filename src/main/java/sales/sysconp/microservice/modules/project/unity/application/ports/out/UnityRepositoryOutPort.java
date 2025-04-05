package sales.sysconp.microservice.modules.project.unity.application.ports.out;

import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UnityRepositoryOutPort {
    UnityModel findById(Long id);

    UnityModel findByUuid(UUID uuid);

    UnityModel findByIdAndProperty(Long id, Long propertyId);

    UnityModel findByUuidAndProperty(UUID uuid, Long propertyId);

    UnityModel save(UnityModel unityModel);

    List<UnityModel> findByProperty(Long propertyId);

    void delete(Long id);
}