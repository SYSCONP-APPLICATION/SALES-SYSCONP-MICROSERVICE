package sales.sysconp.microservice.features.installment.application.ports.in;

import sales.sysconp.microservice.features.installment.application.dto.InstallmentCreateRequestDTO;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentCreatedResponseDTO;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentResponseDTO;

import java.util.List;
import java.util.UUID;

public interface InstallmentServiceInPort {
    InstallmentResponseDTO getInstallmentById(Long id);

    InstallmentResponseDTO getInstallmentByUUID(UUID uuid);

    List<InstallmentResponseDTO> getAllInstallmentsBySaleId(Long saleId);

    InstallmentCreatedResponseDTO createInstallment(InstallmentCreateRequestDTO request);

    List<InstallmentResponseDTO> getAllInstallmentsBySaleUUID(UUID saleUUID);

    void deleteInstallmentById(Long id);
}