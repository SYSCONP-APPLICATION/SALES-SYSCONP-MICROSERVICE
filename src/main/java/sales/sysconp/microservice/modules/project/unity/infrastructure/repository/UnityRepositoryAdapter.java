package sales.sysconp.microservice.modules.project.unity.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.modules.project.unity.application.ports.out.UnityRepositoryOutPort;
import sales.sysconp.microservice.modules.project.unity.domain.enums.UnityStatusEnum;
import sales.sysconp.microservice.modules.project.unity.domain.mappers.UnityMapper;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;

import java.util.List;
import java.util.UUID;

@Repository
public class UnityRepositoryAdapter implements UnityRepositoryOutPort {
    private final JPAUnityRepository jpaRepository;
    private final UnityMapper unityMapper;

    public UnityRepositoryAdapter(JPAUnityRepository jpaRepository, UnityMapper unityMapper) {
        this.jpaRepository = jpaRepository;
        this.unityMapper = unityMapper;
    }

    @Override
    public UnityModel findById(Long id) {
        return unityMapper.toModel(jpaRepository.findById(id).orElseThrow());
    }

    @Override
    public UnityModel findByUuid(UUID uuid) {
        return unityMapper.toModel(jpaRepository.findByUuid(uuid).orElseThrow());
    }

    @Override
    public UnityModel findByIdAndProperty(Long id, Long propertyId) {
        return unityMapper.toModel(jpaRepository.findByIdAndPropertyId(id, propertyId).orElseThrow());
    }

    @Override
    public UnityModel findByUuidAndProperty(UUID uuid, Long propertyId) {
        return unityMapper.toModel(jpaRepository.findByUuidAndPropertyId(uuid, propertyId).orElseThrow());
    }

    @Override
    public int updateStatusesByIds(List<Long> unityIds, UnityStatusEnum status) {
        return jpaRepository.updateStatusesByIds(status, unityIds);
    }

    @Override
    public List<UnityModel> findByPropertyIdAndStatus(Long propertyId, UnityStatusEnum status) {
        return jpaRepository.findByStatusAndPropertyId(status, propertyId).stream()
                .map(unityMapper::toModel)
                .toList();
    }

    @Override
    public List<UnityModel> findAllById(List<Long> ids) {
        return jpaRepository.findAllByIds(ids).stream().map(unityMapper::toModel).toList();
    }

    @Override
    public List<UnityModel> findUnitiesInArrayAndStatus(List<Long> unitiesArray, UnityStatusEnum status) {
        return jpaRepository.findUnitiesInArrayAndStatus(unitiesArray, status).stream()
                .map(unityMapper::toModel)
                .toList();
    }

    @Override
    public UnityModel save(UnityModel unityModel) {
        return unityMapper.toModel(jpaRepository.save(unityMapper.toEntity(unityModel)));
    }

    @Override
    public List<UnityModel> findByProperty(Long propertyId) {
        return jpaRepository.findByPropertyId(propertyId).stream().map(unityMapper::toModel).toList();
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
