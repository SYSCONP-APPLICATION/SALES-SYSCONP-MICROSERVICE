package sales.sysconp.microservice.featuresd.sale.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.features.sale.application.ports.out.SaleRepositoryOutPort;
import sales.sysconp.microservice.features.sale.domain.mappers.SaleMapper;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.features.sale.infrastructure.repository.JPASaleRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SaleRepositoryAdapter implements SaleRepositoryOutPort {
    private final sales.sysconp.microservice.features.sale.infrastructure.repository.JPASaleRepository jpaRepository;
    private final SaleMapper saleMapper;

    public SaleRepositoryAdapter(JPASaleRepository jpaRepository, SaleMapper saleMapper) {
        this.jpaRepository = jpaRepository;
        this.saleMapper = saleMapper;
    }

    @Override
    public List<SaleModel> findAllByCompanyId(Long companyId) {
        return jpaRepository.findAllByCompanyId(companyId)
                .stream()
                .map(saleMapper::toModel)
                .toList();
    }

    @Override
    public Optional<SaleModel> findById(Long id) {
        return jpaRepository.findById(id)
                .map(saleMapper::toModel);
    }

    @Override
    public Optional<SaleModel> findByUUID(UUID uuid) {
        return jpaRepository.findByUuid(uuid)
                .map(saleMapper::toModel);
    }

    @Override
    public SaleModel save(SaleModel saleModel) {
        var entity = saleMapper.toEntity(saleModel);
        var savedEntity = jpaRepository.save(entity);
        return saleMapper.toModel(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
