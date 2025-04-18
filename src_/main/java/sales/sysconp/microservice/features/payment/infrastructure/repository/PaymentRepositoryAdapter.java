package sales.sysconp.microservice.features.payment.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.features.payment.application.ports.out.PaymentRepositoryOutPort;
import sales.sysconp.microservice.features.payment.domain.mappers.PaymentMapper;
import sales.sysconp.microservice.features.payment.domain.models.PaymentModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PaymentRepositoryAdapter implements PaymentRepositoryOutPort {
    private final JPAPaymentRepository jpaRepository;
    private final PaymentMapper mapper;

    public PaymentRepositoryAdapter(JPAPaymentRepository jpaRepository, PaymentMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<PaymentModel> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public Optional<PaymentModel> findByUUID(UUID uuid) {
        return jpaRepository.findByUuid(uuid).map(mapper::toModel);
    }

    @Override
    public List<PaymentModel> findAllBySaleId(Long saleId) {
        return jpaRepository.findAllBySaleId(saleId).stream().map(mapper::toModel).toList();
    }

    @Override
    public List<PaymentModel> findAllByCompanyId(Long companyId) {
        return jpaRepository.findAllByCompanyId(companyId).stream().map(mapper::toModel).toList();
    }

    @Override
    public PaymentModel save(PaymentModel paymentModel) {
        return mapper.toModel(jpaRepository.save(mapper.toEntity(paymentModel)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
