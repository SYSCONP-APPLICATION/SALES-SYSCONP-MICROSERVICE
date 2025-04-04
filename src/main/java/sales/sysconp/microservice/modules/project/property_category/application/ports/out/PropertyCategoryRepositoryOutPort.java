package sales.sysconp.microservice.modules.project.property_category.application.ports.out;

import sales.sysconp.microservice.modules.project.property_category.domain.models.PropertyCategoryModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PropertyCategoryRepositoryOutPort {
    List<PropertyCategoryModel> findAllByCompanyId(Long companyId);

    Optional<PropertyCategoryModel> findByNameAndCompanyId(String name, Long companyId);

    Optional<PropertyCategoryModel> findById(Long id);

    Optional<PropertyCategoryModel> findByUUID(UUID uuid);

    Optional<PropertyCategoryModel> findByIdAndCompanyId(Long id, Long companyId);

    Optional<PropertyCategoryModel> findByUUIDAndCompanyId(UUID uuid, Long companyId);

    PropertyCategoryModel save(PropertyCategoryModel model);

    void deleteById(Long id);
}