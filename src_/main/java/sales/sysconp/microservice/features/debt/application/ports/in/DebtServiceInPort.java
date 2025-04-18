package sales.sysconp.microservice.features.debt.application.ports.in;

import sales.sysconp.microservice.features.debt.application.dto.DebtCreateRequestDTO;
import sales.sysconp.microservice.features.debt.application.dto.DebtResponseDTO;

import java.util.List;
import java.util.UUID;

public interface DebtServiceInPort {
    DebtResponseDTO getDebtById(Long id);

    DebtResponseDTO getDebtByUUID(UUID uuid);

    List<DebtResponseDTO> getAllDebtsBySaleId(Long saleId);

    List<DebtResponseDTO> getAllDebtsByClientId(Long clientId);

    DebtResponseDTO createDebt(DebtCreateRequestDTO debtCreateRequestDTO);

    DebtResponseDTO forgiveDebt(Long id, Long userId);

    DebtResponseDTO payDebt(Long id, Long userId);

    void deleteDebtById(Long id);
}
