package sales.sysconp.microservice.features.payment.application.ports.in;

import sales.sysconp.microservice.features.payment.application.dto.PaymentCreateRequestDTO;
import sales.sysconp.microservice.features.payment.application.dto.PaymentResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PaymentServiceInPort {
    PaymentResponseDTO getPaymentById(Long id);

    PaymentResponseDTO getPaymentByUUID(UUID uuid);

    List<PaymentResponseDTO> getPaymentsBySaleId(Long saleId);

    List<PaymentResponseDTO> getPaymentsByCompanyId(Long companyId);

    PaymentResponseDTO createPayment(PaymentCreateRequestDTO paymentCreateRequestDTO);

    void deleteById(Long id);

}