package sales.sysconp.microservice.config.features.payment_method.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.features.payment_method.application.ports.out.PaymentMethodRepositoryOutPort;
import sales.sysconp.microservice.features.payment_method.domain.mappers.PaymentMethodMapper;
import sales.sysconp.microservice.features.payment_method.domain.models.PaymentMethodModel;
import sales.sysconp.microservice.features.payment_method.infrastructure.repository.JPAPaymentMethodRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PaymentMethodRepositoryAdapter implements PaymentMethodRepositoryOutPort {
    private final sales.sysconp.microservice.features.payment_method.infrastructure.repository.JPAPaymentMethodRepository jpaRepository;
    private final PaymentMethodMapper mapper;

    public PaymentMethodRepositoryAdapter(JPAPaymentMethodRepository jpaRepository, PaymentMethodMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<PaymentMethodModel> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public Optional<PaymentMethodModel> findByUuid(UUID uuid) {
        return jpaRepository.findByUuid(uuid).map(mapper::toModel);
    }

    @Override
    public Optional<PaymentMethodModel> findByNameAndCompanyId(String name, Long companyId) {
        return jpaRepository.findByNameAndCompanyId(name, companyId).map(mapper::toModel);
    }

    @Override
    public List<PaymentMethodModel> findByCompanyId(Long companyId) {
        return jpaRepository.findByCompanyId(companyId).stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public PaymentMethodModel save(PaymentMethodModel paymentMethodModel) {
        return mapper.toModel(jpaRepository.save(mapper.toEntity(paymentMethodModel)));
    }

    @Override
    public void delete(Long id) {
        this.jpaRepository.deleteById(id);
    }
}
