package sales.sysconp.microservice.modules.project.property_category.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.modules.project.property_category.application.ports.out.PropertyCategoryRepositoryOutPort;
import sales.sysconp.microservice.modules.project.property_category.domain.mappers.PropertyCategoryMapper;
import sales.sysconp.microservice.modules.project.property_category.domain.models.PropertyCategoryModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PropertyCategoryRepositoryAdapter implements PropertyCategoryRepositoryOutPort {
    private final JPAPropertyCategoryRepository jpaRepository;
    private final PropertyCategoryMapper propertyCategoryMapper;

    public PropertyCategoryRepositoryAdapter(JPAPropertyCategoryRepository jpaRepository, PropertyCategoryMapper propertyCategoryMapper) {
        this.jpaRepository = jpaRepository;
        this.propertyCategoryMapper = propertyCategoryMapper;
    }

    @Override
    public List<PropertyCategoryModel> findAllByCompanyId(Long companyId) {
        return jpaRepository.findAllByCompanyId(companyId)
                .stream()
                .map(propertyCategoryMapper::toModel)
                .toList();
    }

    @Override
    public Optional<PropertyCategoryModel> findByNameAndCompanyId(String name, Long companyId) {
        return jpaRepository.findByNameAndCompanyId(name, companyId)
                .map(propertyCategoryMapper::toModel);
    }

    @Override
    public Optional<PropertyCategoryModel> findById(Long id) {
        return jpaRepository.findById(id)
                .map(propertyCategoryMapper::toModel);
    }

    @Override
    public Optional<PropertyCategoryModel> findByUUID(UUID uuid) {
        return jpaRepository.findByUuid(uuid)
                .map(propertyCategoryMapper::toModel);
    }

    @Override
    public Optional<PropertyCategoryModel> findByIdAndCompanyId(Long id, Long companyId) {
        return jpaRepository
                .findByIdAndCompanyId(id, companyId)
                .map(propertyCategoryMapper::toModel);
    }

    @Override
    public Optional<PropertyCategoryModel> findByUUIDAndCompanyId(UUID uuid, Long companyId) {
        return jpaRepository
                .findByUuidAndCompanyId(uuid, companyId)
                .map(propertyCategoryMapper::toModel);
    }

    @Override
    public PropertyCategoryModel save(PropertyCategoryModel model) {
        return propertyCategoryMapper.toModel(jpaRepository.save(propertyCategoryMapper.toEntity(model)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
