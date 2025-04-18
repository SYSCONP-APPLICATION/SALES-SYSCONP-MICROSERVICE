package sales.sysconp.microservice.features.system_payment_configuration.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.system_payment_configuration.application.dto.SystemPaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.system_payment_configuration.domain.models.SystemPaymentConfigurationModel;
import sales.sysconp.microservice.features.system_payment_configuration.infrastructure.entities.SystemPaymentConfigurationEntity;
import sales.sysconp.microservice.modules.auth.company.domain.mapper.CompanyMapper;

@Mapper(componentModel = "spring", uses = { CompanyMapper.class })
public interface SystemPaymentConfigurationMapper {
    SystemPaymentConfigurationModel toModel(SystemPaymentConfigurationEntity entity);
    SystemPaymentConfigurationEntity toEntity(SystemPaymentConfigurationModel model);
    SystemPaymentConfigurationResponseDTO toResponseDTO(SystemPaymentConfigurationModel model);
}
