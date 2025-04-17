package sales.sysconp.microservice.featuresd.payment_configuration.application.ports.out;

import sales.sysconp.microservice.features.payment_configuration.domain.models.PaymentConfigurationModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentConfigurationRepositoryOutPort {
    Optional<PaymentConfigurationModel> findById(Long id);

    Optional<PaymentConfigurationModel> findByUUID(UUID uuid);

    List<PaymentConfigurationModel> findBySaleId(Long saleId);

    PaymentConfigurationModel save(PaymentConfigurationModel paymentConfigurationModel);

    void deleteById(Long id);
}