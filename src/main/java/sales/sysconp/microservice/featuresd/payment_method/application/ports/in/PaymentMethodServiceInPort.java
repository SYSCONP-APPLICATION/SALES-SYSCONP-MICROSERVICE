package sales.sysconp.microservice.featuresd.payment_method.application.ports.in;

import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodCreateRequestDTO;
import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodResponseDTO;
import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface PaymentMethodServiceInPort {
    PaymentMethodResponseDTO getPaymentMethodById(Long id);

    List<PaymentMethodResponseDTO> getPaymentMethodByCompanyId(Long companyId);

    PaymentMethodResponseDTO getPaymentMethodByUUID(UUID uuid);

    PaymentMethodResponseDTO createPaymentMethod(PaymentMethodCreateRequestDTO request);

    PaymentMethodResponseDTO updatePaymentMethod(Long id, PaymentMethodUpdateRequestDTO request);

    void deletePaymentMethod(Long id);
}