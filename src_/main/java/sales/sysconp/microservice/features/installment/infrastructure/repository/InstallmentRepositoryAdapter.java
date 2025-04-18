package sales.sysconp.microservice.features.installment.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.features.installment.application.ports.out.InstallmentRepositoryOutPort;
import sales.sysconp.microservice.features.installment.domain.mappers.InstallmentMapper;
import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InstallmentRepositoryAdapter implements InstallmentRepositoryOutPort {
    private final JPAInstallmentRepository jpaRepository;
    private final InstallmentMapper installmentMapper;

    public InstallmentRepositoryAdapter(JPAInstallmentRepository jpaRepository, InstallmentMapper installmentMapper) {
        this.jpaRepository = jpaRepository;
        this.installmentMapper = installmentMapper;
    }

    @Override
    public List<InstallmentModel> findAllBySaleId(Long saleId) {
        return jpaRepository.findBySaleId(saleId).stream()
                .map(installmentMapper::toModel)
                .toList();
    }

    @Override
    public Optional<InstallmentModel> findById(Long id) {
        return jpaRepository.findById(id).map(installmentMapper::toModel);
    }

    @Override
    public Optional<InstallmentModel> findByUUID(UUID uuid) {
        return jpaRepository.findByUuid(uuid)
                .map(installmentMapper::toModel);
    }

    @Override
    public InstallmentModel save(InstallmentModel installmentModel) {
        return installmentMapper.toModel(
                jpaRepository.save(installmentMapper.toEntity(installmentModel))
        );
    }

    @Override
    public List<InstallmentModel> saveAll(List<InstallmentModel> installmentModels) {
        return jpaRepository.saveAll(installmentModels.stream()
                .map(installmentMapper::toEntity)
                .toList()).stream()
                .map(installmentMapper::toModel)
                .toList();
    }

    @Override
    public List<InstallmentModel> findBySaleUuid(UUID saleUuid) {
        return jpaRepository.findBySaleUuid(saleUuid).stream()
                .map(installmentMapper::toModel)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}