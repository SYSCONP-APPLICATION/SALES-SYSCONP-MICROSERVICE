package sales.sysconp.microservice.features.system_payment_configuration.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.system_payment_configuration.domain.models.SystemPaymentConfigurationModel;
import sales.sysconp.microservice.features.system_payment_configuration.infrastructure.entities.SystemPaymentConfigurationEntity;

@Mapper(componentModel = "spring", uses = { })
public interface SystemPaymentConfigurationMapper {
    SystemPaymentConfigurationModel toModel(SystemPaymentConfigurationEntity entity);
    SystemPaymentConfigurationEntity toEntity(SystemPaymentConfigurationModel model);
}
