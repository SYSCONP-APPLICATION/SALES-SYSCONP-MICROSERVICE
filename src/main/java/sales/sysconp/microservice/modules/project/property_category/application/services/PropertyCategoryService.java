package sales.sysconp.microservice.modules.project.property_category.application.services;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.repository.CompanyRepositoryAdapter;
import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryCreateRequestDTO;
import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryResponseDTO;
import sales.sysconp.microservice.modules.project.property_category.application.dto.PropertyCategoryUpdateRequestDTO;
import sales.sysconp.microservice.modules.project.property_category.application.ports.in.PropertyCategoryServiceInPort;
import sales.sysconp.microservice.modules.project.property_category.domain.mappers.PropertyCategoryMapper;
import sales.sysconp.microservice.modules.project.property_category.domain.models.PropertyCategoryModel;
import sales.sysconp.microservice.modules.project.property_category.infrastructure.repository.PropertyCategoryRepositoryAdapter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PropertyCategoryService implements PropertyCategoryServiceInPort {

    private final PropertyCategoryRepositoryAdapter propertyCategoryRepositoryAdapter;
    private final CompanyRepositoryAdapter companyRepositoryAdapter;
    private final PropertyCategoryMapper propertyCategoryMapper;

    public PropertyCategoryService(PropertyCategoryRepositoryAdapter propertyCategoryRepositoryAdapter, CompanyRepositoryAdapter companyRepositoryAdapter, PropertyCategoryMapper propertyCategoryMapper) {
        this.propertyCategoryRepositoryAdapter = propertyCategoryRepositoryAdapter;
        this.companyRepositoryAdapter = companyRepositoryAdapter;
        this.propertyCategoryMapper = propertyCategoryMapper;
    }

    @Override
    public List<PropertyCategoryResponseDTO> getAllCompanyPropertyCategories(Long companyId) {
        this.companyRepositoryAdapter.findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company not found!"));

        return propertyCategoryRepositoryAdapter.findAllByCompanyId(companyId)
                .stream()
                .map(propertyCategoryMapper::toResponseDTO)
                .toList();
    }

    @Override
    public PropertyCategoryResponseDTO getPropertyCategoryById(Long id) {
        return propertyCategoryRepositoryAdapter.findById(id)
                .map(propertyCategoryMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Property category not found"));
    }

    @Override
    public PropertyCategoryResponseDTO getPropertyCategoryByUUID(UUID uuid) {
        return propertyCategoryRepositoryAdapter.findByUUID(uuid)
                .map(propertyCategoryMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Property category not found"));
    }

    @Override
    public PropertyCategoryResponseDTO createPropertyCategory(PropertyCategoryCreateRequestDTO propertyCategoryCreateRequestDTO) {
        Optional<PropertyCategoryModel> propertyById = this.propertyCategoryRepositoryAdapter.findByIdAndCompanyId(propertyCategoryCreateRequestDTO.getId(), propertyCategoryCreateRequestDTO.getCompanyId());

        if (propertyById.isPresent()) {
            throw new EntityExistsException("Já existe uma categoria de propriedade com esse id!");
        }

        Optional<PropertyCategoryModel> propertyByUuid = this.propertyCategoryRepositoryAdapter.findByUUIDAndCompanyId(propertyCategoryCreateRequestDTO.getUuid(), propertyCategoryCreateRequestDTO.getCompanyId());

        if (propertyByUuid.isPresent()) {
            throw new EntityExistsException("Já existe uma categoria de propriedade com esse uuid!");
        }

        Optional<PropertyCategoryModel> propertyByName = this.propertyCategoryRepositoryAdapter.findByNameAndCompanyId(propertyCategoryCreateRequestDTO.getName(), propertyCategoryCreateRequestDTO.getCompanyId());

        if (propertyByName.isPresent()) {
            throw new EntityExistsException("Já existe uma categoria de propriedade com esse nome!");
        }

        CompanyModel companyById = this.companyRepositoryAdapter
                .findById(propertyCategoryCreateRequestDTO.getCompanyId())
                .orElseThrow(() -> new NoSuchElementException("Empresa não encontrada"));

        PropertyCategoryModel propertyCategoryModel = new PropertyCategoryModel();

        propertyCategoryModel.setId(propertyCategoryCreateRequestDTO.getId());
        propertyCategoryModel.setUuid(propertyCategoryCreateRequestDTO.getUuid());
        propertyCategoryModel.setName(propertyCategoryCreateRequestDTO.getName());
        propertyCategoryModel.setCompany(companyById);
        propertyCategoryModel.setCreatedAt(propertyCategoryCreateRequestDTO.getCreatedAt());
        propertyCategoryModel.setUpdatedAt(propertyCategoryCreateRequestDTO.getUpdatedAt());

        return propertyCategoryMapper.toResponseDTO(this.propertyCategoryRepositoryAdapter.save(propertyCategoryModel));
    }

    @Override
    public PropertyCategoryResponseDTO updatePropertyCategory(Long id, PropertyCategoryUpdateRequestDTO propertyCategoryUpdateRequestDTO) {
        PropertyCategoryModel propertyCategoryById = this.propertyCategoryRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Property category not found"));

        Optional<PropertyCategoryModel> propertyByNameAndCompanyId = this.propertyCategoryRepositoryAdapter
                .findByNameAndCompanyId(propertyCategoryUpdateRequestDTO.getName(), propertyCategoryById.getCompany().getId());

        if (propertyByNameAndCompanyId.isPresent() && !propertyByNameAndCompanyId.get().getId().equals(id)) {
            throw new EntityExistsException("Já existe uma categoria de propriedade com esse nome e id de empresa!");
        }

        propertyCategoryById.setName(propertyCategoryUpdateRequestDTO.getName());
        propertyCategoryById.setUpdatedAt(propertyCategoryUpdateRequestDTO.getUpdatedAt());

        return propertyCategoryMapper.toResponseDTO(this.propertyCategoryRepositoryAdapter.save(propertyCategoryById));
    }

    @Override
    public void deletePropertyCategory(Long id) {
        this.propertyCategoryRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property category not found"));

        this.propertyCategoryRepositoryAdapter.deleteById(id);
    }
}
