package sales.sysconp.microservice.features.payment.application.ports.out;

import sales.sysconp.microservice.features.payment.domain.models.PaymentModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepositoryOutPort {
    Optional<PaymentModel> findById(Long id);

    Optional<PaymentModel> findByUUID(UUID uuid);

    List<PaymentModel> findAllBySaleId(Long saleId);

    List<PaymentModel> findAllByCompanyId(Long companyId);

    PaymentModel save(PaymentModel paymentModel);

    void deleteById(Long id);
}