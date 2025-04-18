package sales.sysconp.microservice.root.transactionals.sale.application.ports.in;

import sales.sysconp.microservice.root.transactionals.sale.application.dto.CreateSaleWithInstallmentCreateRequestDTO;
import sales.sysconp.microservice.root.transactionals.sale.application.dto.CreateSaleWithInstallmentResponseDTO;

public interface CreateSaleWithInstallmentInPort {
    CreateSaleWithInstallmentResponseDTO execute(CreateSaleWithInstallmentCreateRequestDTO createSaleWithInstallmentCreateRequestDTO);
}