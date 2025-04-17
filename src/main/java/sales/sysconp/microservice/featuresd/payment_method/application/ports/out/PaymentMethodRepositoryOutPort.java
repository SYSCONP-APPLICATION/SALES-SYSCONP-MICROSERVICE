package sales.sysconp.microservice.featuresd.payment_method.application.ports.out;

import sales.sysconp.microservice.features.payment_method.domain.models.PaymentMethodModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentMethodRepositoryOutPort {
    Optional<PaymentMethodModel> findById(Long id);

    Optional<PaymentMethodModel> findByUuid(UUID uuid);

    Optional<PaymentMethodModel> findByNameAndCompanyId(String name, Long companyId);

    List<PaymentMethodModel> findByCompanyId(Long companyId);

    PaymentMethodModel save(PaymentMethodModel paymentMethodModel);

    void delete(Long id);
}
