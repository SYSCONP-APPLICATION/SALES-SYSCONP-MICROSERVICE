package sales.sysconp.microservice.features.sale.application.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.features.client.infrastructure.repository.ClientRepositoryAdapter;
import sales.sysconp.microservice.features.sale.application.dto.SaleCreateRequestDTO;
import sales.sysconp.microservice.features.sale.application.dto.SaleResponseDTO;
import sales.sysconp.microservice.features.sale.application.dto.SaleUpdateRequestDTO;
import sales.sysconp.microservice.features.sale.application.ports.in.SaleServiceInPort;
import sales.sysconp.microservice.features.sale.domain.enums.SaleStatus;
import sales.sysconp.microservice.features.sale.domain.mappers.SaleMapper;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.features.sale.infrastructure.repository.SaleRepositoryAdapter;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.repository.CompanyRepositoryAdapter;
import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;
import sales.sysconp.microservice.modules.auth.user.infrastructure.repository.UserRepositoryAdapter;
import sales.sysconp.microservice.modules.project.project.application.services.ProjectService;
import sales.sysconp.microservice.modules.project.project.domain.enums.ProjectStatusEnum;
import sales.sysconp.microservice.modules.project.project.infrastructure.repository.ProjectRepositoryAdapter;
import sales.sysconp.microservice.modules.project.property.domain.enums.PropertyStatusEnum;
import sales.sysconp.microservice.modules.project.property.domain.models.PropertyModel;
import sales.sysconp.microservice.modules.project.property.infrastructure.repository.PropertyRepositoryAdapter;
import sales.sysconp.microservice.modules.project.unity.application.services.UnityService;
import sales.sysconp.microservice.modules.project.unity.domain.enums.UnityStatusEnum;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;
import sales.sysconp.microservice.modules.project.unity.infrastructure.repository.UnityRepositoryAdapter;

import java.util.*;

@Service
public class SaleService implements SaleServiceInPort {
    private final SaleRepositoryAdapter saleRepositoryAdapter;
    private final UserRepositoryAdapter userRepositoryAdapter;
    private final CompanyRepositoryAdapter companyRepositoryAdapter;
    private final ClientRepositoryAdapter clientRepositoryAdapter;
    private final UnityRepositoryAdapter unityRepositoryAdapter;
    private final PropertyRepositoryAdapter propertyRepositoryAdapter;
    private final ProjectRepositoryAdapter projectRepositoryAdapter;
    private final SaleMapper saleMapper;

    public SaleService(SaleRepositoryAdapter saleRepositoryAdapter, ProjectRepositoryAdapter projectRepositoryAdapter, PropertyRepositoryAdapter propertyRepositoryAdapter, UnityService unityService, SaleMapper saleMapper, UserRepositoryAdapter userRepositoryAdapter, CompanyRepositoryAdapter companyRepositoryAdapter, ClientRepositoryAdapter clientRepositoryAdapter, UnityRepositoryAdapter unityRepositoryAdapter) {
        this.saleRepositoryAdapter = saleRepositoryAdapter;
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.companyRepositoryAdapter = companyRepositoryAdapter;
        this.propertyRepositoryAdapter = propertyRepositoryAdapter;
        this.clientRepositoryAdapter = clientRepositoryAdapter;
        this.unityRepositoryAdapter = unityRepositoryAdapter;
        this.projectRepositoryAdapter = projectRepositoryAdapter;
        this.saleMapper = saleMapper;
    }

    @Override
    public List<SaleResponseDTO> getAllSalesByCompany(Long companyId) {
        this.companyRepositoryAdapter
                .findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company not found with id: " + companyId));

        return this.saleRepositoryAdapter
                .findAllByCompanyId(companyId)
                .stream()
                .map(saleMapper::toResponseDTO)
                .toList();
    }

    @Override
    public SaleResponseDTO getSaleById(Long id) {
        return this.saleRepositoryAdapter
                .findById(id)
                .map(saleMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Sale not found with id: " + id));
    }

    @Override
    public SaleResponseDTO getSaleByUUID(UUID uuid) {
        return this.saleRepositoryAdapter
                .findByUUID(uuid)
                .map(saleMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Sale not found with uuid: " + uuid));
    }

    @Transactional
    @Override
    public SaleResponseDTO createSale(SaleCreateRequestDTO dto) {
        CompanyModel company = this.companyRepositoryAdapter
                .findById(dto.getCompanyId())
                .orElseThrow(() -> new NoSuchElementException("Company not found with id: " + dto.getCompanyId()));

        ClientModel client = this.clientRepositoryAdapter
                .findByIdAndCompanyId(dto.getClientId(), company.getId())
                .orElseThrow(() -> new NoSuchElementException("Client not found with id: " + dto.getClientId()));

        UserModel user = this.userRepositoryAdapter
                .findById(dto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + dto.getUserId()));

        SaleModel newSale = new SaleModel();

        newSale.setStatus(SaleStatus.IN_PROGRESS);
        newSale.setCompany(company);
        newSale.setClient(client);
        newSale.setUser(user);

        SaleModel savedSale = this.saleRepositoryAdapter.save(newSale);

        dto.getUnitiesArray().forEach(unityId -> {
            UnityModel unity = this.unityRepositoryAdapter.findById(unityId);

            if (unity == null || unity.getStatus() != UnityStatusEnum.AVAILABLE) {
                throw new NoSuchElementException("Unity not found with id: " + unityId + " or it is not available");
            }

            unity.setStatus(UnityStatusEnum.IN_SALE);
            unity.setSale(savedSale);
            this.unityRepositoryAdapter.save(unity);

            List<UnityModel> unities = this.unityRepositoryAdapter.findByPropertyIdAndStatus(
                    unity.getProperty().getId(), UnityStatusEnum.AVAILABLE
            );

            if (unities.isEmpty()) {
                PropertyModel propertyModel = propertyRepositoryAdapter
                        .getPropertyById(unity.getProperty().getId())
                        .orElseThrow(() -> new NoSuchElementException("Property not found"));

                propertyModel.setStatus(PropertyStatusEnum.WITHOUT_SPACE);
                propertyRepositoryAdapter.save(propertyModel);
            }

            Long projectId = unity.getProperty().getProject().getId();
            List<PropertyModel> properties = this.propertyRepositoryAdapter
                    .getPropertiesByStatusAndProjectId(PropertyStatusEnum.WITH_SPACE, projectId);

            if (properties.isEmpty()) {
                this.projectRepositoryAdapter.updateProjectStatus(projectId, ProjectStatusEnum.COMPLETED);
            }
        });

        SaleModel createdSale = this.saleRepositoryAdapter
                .findById(savedSale.getId())
                .orElseThrow(() -> new NoSuchElementException("Sale not found with id: " + savedSale.getId()));

        return this.saleMapper.toResponseDTO(createdSale);
    }


    @Override
    public SaleResponseDTO updateSale(Long id, SaleUpdateRequestDTO dto) {
        SaleModel sale = this.saleRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Sale not found with id: " + id));

        sale.setStatus(dto.getStatus());

        return this.saleMapper.toResponseDTO(this.saleRepositoryAdapter.save(sale));
    }

    @Override
    public void deleteSale(Long id) {
        this.saleRepositoryAdapter
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Sale not found with id: " + id));

        saleRepositoryAdapter.deleteById(id);
    }
}