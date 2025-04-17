package sales.sysconp.microservice.config.features.payment_configuration.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.payment_configuration.domain.models.PaymentConfigurationModel;
import sales.sysconp.microservice.features.payment_configuration.infrastructure.entities.PaymentConfigurationEntity;
import sales.sysconp.microservice.features.sale.domain.mappers.SaleMapper;

@Mapper(componentModel = "spring", uses = { SaleMapper.class })
public interface PaymentConfigurationMapper {
    PaymentConfigurationModel toModel(PaymentConfigurationEntity entity);
    PaymentConfigurationEntity toEntity(PaymentConfigurationModel model);
    PaymentConfigurationResponseDTO toResponseDTO(PaymentConfigurationModel model);
}
