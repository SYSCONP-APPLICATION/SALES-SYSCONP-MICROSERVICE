package sales.sysconp.microservice.root.transationals.sale.application.ports.in;

import sales.sysconp.microservice.root.transationals.sale.application.dto.CreateSaleWithInstallmentCreateRequestDTO;
import sales.sysconp.microservice.root.transationals.sale.application.dto.CreateSaleWithInstallmentResponseDTO;

public interface CreateSaleWithInstallmentInPort {
    CreateSaleWithInstallmentResponseDTO execute(CreateSaleWithInstallmentCreateRequestDTO createSaleWithInstallmentCreateRequestDTO);
}