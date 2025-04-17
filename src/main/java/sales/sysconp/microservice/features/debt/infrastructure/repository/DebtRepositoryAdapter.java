package sales.sysconp.microservice.features.debt.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.features.debt.application.ports.out.DebtRepositoryOutPort;
import sales.sysconp.microservice.features.debt.domain.mappers.DebtMapper;
import sales.sysconp.microservice.features.debt.domain.models.DebtModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class DebtRepositoryAdapter implements DebtRepositoryOutPort {
    private final JPADebtRepository jpaRepository;
    private final DebtMapper mapper;

    public DebtRepositoryAdapter(JPADebtRepository jpaRepository, DebtMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DebtModel> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public Optional<DebtModel> findByUUID(UUID uuid) {
        return jpaRepository.findByUuid(uuid).map(mapper::toModel);
    }

    @Override
    public List<DebtModel> findAllBySaleId(Long saleId) {
        return jpaRepository.findByInstallment_Sale_Id(saleId).stream().map(mapper::toModel).toList();
    }

    @Override
    public List<DebtModel> findAllByClientId(Long clientId) {
        return jpaRepository.findByInstallment_Sale_Client_Id(clientId).stream().map(mapper::toModel).toList();
    }

    @Override
    public DebtModel save(DebtModel debtModel) {
        return mapper.toModel(jpaRepository.save(mapper.toEntity(debtModel)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
