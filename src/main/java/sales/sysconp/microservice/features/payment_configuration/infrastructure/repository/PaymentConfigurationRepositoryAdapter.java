package sales.sysconp.microservice.features.payment_configuration.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.features.payment_configuration.application.ports.out.PaymentConfigurationRepositoryOutPort;
import sales.sysconp.microservice.features.payment_configuration.domain.mappers.PaymentConfigurationMapper;
import sales.sysconp.microservice.features.payment_configuration.domain.models.PaymentConfigurationModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PaymentConfigurationRepositoryAdapter implements PaymentConfigurationRepositoryOutPort {
    private final JPAPaymentConfigurationRepository jpaRepository;
    private final PaymentConfigurationMapper mapper;

    public PaymentConfigurationRepositoryAdapter(JPAPaymentConfigurationRepository jpaRepository, PaymentConfigurationMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<PaymentConfigurationModel> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public Optional<PaymentConfigurationModel> findByUUID(UUID uuid) {
        return jpaRepository.findByUuid(uuid).map(mapper::toModel);
    }

    @Override
    public List<PaymentConfigurationModel> findBySaleId(Long companyId) {
        return jpaRepository.findBySaleId(companyId).stream().map(mapper::toModel).toList();
    }

    @Override
    public PaymentConfigurationModel save(PaymentConfigurationModel paymentConfigurationModel) {
        return mapper.toModel(jpaRepository.save(mapper.toEntity(paymentConfigurationModel)));
    }

    @Override
    public Optional<PaymentConfigurationModel> findByInstallmentId(Long installmentId) {
        return jpaRepository.findByInstallmentId(installmentId).map(mapper::toModel);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
