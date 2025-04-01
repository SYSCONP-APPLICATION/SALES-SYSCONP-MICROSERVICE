package sales.sysconp.microservice.features.payment_configuration.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.payment_configuration.domain.models.PaymentConfigurationModel;
import sales.sysconp.microservice.features.payment_configuration.infrastructure.entities.PaymentConfigurationEntity;

@Mapper(componentModel = "spring")
public interface PaymentConfigurationMapper {
    PaymentConfigurationModel toModel(PaymentConfigurationEntity entity);
    PaymentConfigurationEntity toEntity(PaymentConfigurationModel model);
}
