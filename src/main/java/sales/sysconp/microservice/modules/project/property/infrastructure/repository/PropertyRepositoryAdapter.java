package sales.sysconp.microservice.modules.project.property.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.modules.project.property.application.ports.out.PropertyRepositoryOutPort;
import sales.sysconp.microservice.modules.project.property.domain.mappers.PropertyMapper;
import sales.sysconp.microservice.modules.project.property.domain.models.PropertyModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PropertyRepositoryAdapter implements PropertyRepositoryOutPort {
    private final JPAPropertyRepository jpaRepository;
    private final PropertyMapper propertyMapper;

    public PropertyRepositoryAdapter(JPAPropertyRepository jpaRepository, PropertyMapper propertyMapper) {
        this.jpaRepository = jpaRepository;
        this.propertyMapper = propertyMapper;
    }

    @Override
    public Optional<PropertyModel> getPropertyByUuid(UUID uuid) {
        return this.jpaRepository.findByUuid(uuid).map(propertyMapper::toModel);
    }

    @Override
    public Optional<PropertyModel> getPropertyById(Long id) {
        return this.jpaRepository.findById(id).map(propertyMapper::toModel);
    }

    @Override
    public List<PropertyModel> getPropertiesByProjectId(Long projectId) {
        return jpaRepository.findByProjectId(projectId).stream()
                .map(propertyMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyModel> getPropertiesByCollectionId(Long collectionId) {
        return jpaRepository.findByCollectionId(collectionId).stream()
                .map(propertyMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyModel> getPropertiesByStreetId(Long streetId) {
        return jpaRepository.findByStreetId(streetId).stream()
                .map(propertyMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyModel> getPropertiesByPropertyCategoryId(Long propertyCategoryId) {
        return jpaRepository.findByPropertyCategoryId(propertyCategoryId).stream()
                .map(propertyMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PropertyModel> getPropertyByNameAndProjectId(String name, Long projectId) {
        return jpaRepository.findByNameAndProjectId(name, projectId).map(propertyMapper::toModel);
    }

    @Override
    public Optional<PropertyModel> getPropertyByIdAndProjectId(Long id, Long projectId) {
        return jpaRepository.findByIdAndProjectId(id, projectId).map(propertyMapper::toModel);
    }

    @Override
    public Optional<PropertyModel> getPropertyByUuidAndProjectId(UUID uuid, Long projectId) {
        return jpaRepository.findByUuidAndProjectId(uuid, projectId).map(propertyMapper::toModel);
    }

    @Override
    public PropertyModel save(PropertyModel propertyModel) {
        return propertyMapper.toModel(jpaRepository.save(propertyMapper.toEntity(propertyModel)));
    }

    @Override
    public void delete(PropertyModel propertyModel) {
        jpaRepository.delete(propertyMapper.toEntity(propertyModel));
    }
}
