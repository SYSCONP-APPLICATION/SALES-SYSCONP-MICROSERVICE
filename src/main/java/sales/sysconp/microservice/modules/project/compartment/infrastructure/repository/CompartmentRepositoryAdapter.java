package sales.sysconp.microservice.modules.project.compartment.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.modules.project.compartment.application.ports.out.CompartmentRepositoryOutPort;
import sales.sysconp.microservice.modules.project.compartment.domain.mappers.CompartmentMapper;
import sales.sysconp.microservice.modules.project.compartment.domain.models.CompartmentModel;
import sales.sysconp.microservice.modules.project.compartment.infrastructure.entities.CompartmentEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CompartmentRepositoryAdapter implements CompartmentRepositoryOutPort {
    private final JPACompartmentRepository jpaRepository;
    private final CompartmentMapper compartmentMapper;

    public CompartmentRepositoryAdapter(JPACompartmentRepository jpaRepository, CompartmentMapper compartmentMapper) {
        this.jpaRepository = jpaRepository;
        this.compartmentMapper = compartmentMapper;
    }

    @Override
    public List<CompartmentModel> findByUnityId(Long unityId) {
        return jpaRepository.findByUnityId(unityId)
                .stream()
                .map(compartmentMapper::toModel)
                .toList();
    }

    @Override
    public Optional<CompartmentModel> findById(Long id) {
        return jpaRepository.findById(id)
                .map(compartmentMapper::toModel);
    }

    @Override
    public Optional<CompartmentModel> findByUuid(UUID uuid) {
        return jpaRepository.findByUuid(uuid)
                .map(compartmentMapper::toModel);
    }

    @Override
    public CompartmentModel save(CompartmentModel compartmentModel) {
        CompartmentEntity entity = compartmentMapper.toEntity(compartmentModel);
        entity = jpaRepository.save(entity);
        return compartmentMapper.toModel(entity);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
