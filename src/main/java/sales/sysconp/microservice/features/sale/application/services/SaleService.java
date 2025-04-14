package sales.sysconp.microservice.features.sale.application.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.features.client.infrastructure.repository.ClientRepositoryAdapter;
import sales.sysconp.microservice.features.sale.application.dto.SaleCreateRequestDTO;
import sales.sysconp.microservice.features.sale.application.dto.SaleResponseDTO;
import sales.sysconp.microservice.features.sale.application.dto.SaleUpdateRequestDTO;
import sales.sysconp.microservice.features.sale.application.ports.in.SaleServiceInPort;
import sales.sysconp.microservice.features.sale.domain.mappers.SaleMapper;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.features.sale.infrastructure.repository.SaleRepositoryAdapter;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.repository.CompanyRepositoryAdapter;
import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;
import sales.sysconp.microservice.modules.auth.user.infrastructure.repository.UserRepositoryAdapter;
import sales.sysconp.microservice.modules.project.unity.application.services.UnityService;
import sales.sysconp.microservice.modules.project.unity.domain.enums.UnityStatusEnum;
import sales.sysconp.microservice.modules.project.unity.domain.models.UnityModel;
import sales.sysconp.microservice.modules.project.unity.infrastructure.repository.UnityRepositoryAdapter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class SaleService implements SaleServiceInPort {
    private final SaleRepositoryAdapter saleRepositoryAdapter;
    private final UserRepositoryAdapter userRepositoryAdapter;
    private final CompanyRepositoryAdapter companyRepositoryAdapter;
    private final ClientRepositoryAdapter clientRepositoryAdapter;
    private final UnityRepositoryAdapter unityRepositoryAdapter;
    private final UnityService unityService;
    private final SaleMapper saleMapper;

    public SaleService(SaleRepositoryAdapter saleRepositoryAdapter, UnityService unityService, SaleMapper saleMapper, UserRepositoryAdapter userRepositoryAdapter, CompanyRepositoryAdapter companyRepositoryAdapter, ClientRepositoryAdapter clientRepositoryAdapter, UnityRepositoryAdapter unityRepositoryAdapter) {
        this.saleRepositoryAdapter = saleRepositoryAdapter;
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.companyRepositoryAdapter = companyRepositoryAdapter;
        this.unityService = unityService;
        this.clientRepositoryAdapter = clientRepositoryAdapter;
        this.unityRepositoryAdapter = unityRepositoryAdapter;
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

        List<UnityModel> unities = this.unityRepositoryAdapter
                .findUnitiesInArrayAndStatus(dto.getUnitiesArray(), UnityStatusEnum.AVAILABLE);

        SaleModel newSale = new SaleModel();

        newSale.setStatus(dto.getStatus());
        newSale.setCompany(company);
        newSale.setClient(client);
        newSale.setUser(user);
        newSale.setUnities(unities);

        // Update unities to unavailable & Check if there are available unities, to update property status
        this.unityService.updateStatusesByIds(newSale.getUnities().stream().map(UnityModel::getId).toList(), UnityStatusEnum.SOLD);

        return this.saleMapper.toResponseDTO(this.saleRepositoryAdapter.save(newSale));
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