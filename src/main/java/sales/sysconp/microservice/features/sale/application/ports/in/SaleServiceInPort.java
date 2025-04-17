package sales.sysconp.microservice.features.sale.application.ports.in;

import sales.sysconp.microservice.features.sale.application.dto.SaleCreateRequestDTO;
import sales.sysconp.microservice.features.sale.application.dto.SaleResponseDTO;
import sales.sysconp.microservice.features.sale.application.dto.SaleUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface SaleServiceInPort {
    List<SaleResponseDTO> getAllSalesByCompany(Long companyId);

    SaleResponseDTO getSaleById(Long id);

    SaleResponseDTO getSaleByUUID(UUID uuid);

    SaleResponseDTO createSale(SaleCreateRequestDTO dto);

    SaleResponseDTO updateSale(Long id, SaleUpdateRequestDTO dto);

    void deleteSale(Long id);
}
