package sales.sysconp.microservice.features.system_payment_configuration.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.features.system_payment_configuration.application.ports.out.SystemPaymentConfigurationRepositoryOutPort;
import sales.sysconp.microservice.features.system_payment_configuration.domain.mappers.SystemPaymentConfigurationMapper;
import sales.sysconp.microservice.features.system_payment_configuration.domain.models.SystemPaymentConfigurationModel;
import sales.sysconp.microservice.features.system_payment_configuration.infrastructure.entities.SystemPaymentConfigurationEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public class SystemPaymentConfigurationRepositoryAdapter implements SystemPaymentConfigurationRepositoryOutPort {
    private final JPASystemPaymentConfigurationRepository jpaRepository;
    private final SystemPaymentConfigurationMapper systemPaymentConfigurationMapper;

    public SystemPaymentConfigurationRepositoryAdapter(JPASystemPaymentConfigurationRepository jpaRepository, SystemPaymentConfigurationMapper systemPaymentConfigurationMapper) {
        this.jpaRepository = jpaRepository;
        this.systemPaymentConfigurationMapper = systemPaymentConfigurationMapper;
    }

    @Override
    public Optional<SystemPaymentConfigurationModel> findByCompanyId(Long companyId) {
        return this.jpaRepository.findByCompanyId(companyId).map(systemPaymentConfigurationMapper::toModel);
    }

    @Override
    public Optional<SystemPaymentConfigurationModel> findById(Long id) {
        return this.jpaRepository.findById(id).map(systemPaymentConfigurationMapper::toModel);
    }

    @Override
    public Optional<SystemPaymentConfigurationModel> findByUUID(UUID uuid) {
        return this.jpaRepository.findByUuid(uuid).map(systemPaymentConfigurationMapper::toModel);
    }

    @Override
    public SystemPaymentConfigurationModel save(SystemPaymentConfigurationModel model) {
        SystemPaymentConfigurationEntity savedModel = this.jpaRepository.save(systemPaymentConfigurationMapper.toEntity(model));
        return systemPaymentConfigurationMapper.toModel(savedModel);
    }

    @Override
    public void deleteById(Long id) {
        this.jpaRepository.deleteById(id);
    }
}
