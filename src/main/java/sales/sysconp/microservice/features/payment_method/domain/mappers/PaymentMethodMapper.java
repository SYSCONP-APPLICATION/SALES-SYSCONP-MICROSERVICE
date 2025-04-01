package sales.sysconp.microservice.features.payment_method.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.payment_method.domain.models.PaymentMethodModel;
import sales.sysconp.microservice.features.payment_method.infrastructure.entities.PaymentMethodEntity;

@Mapper(componentModel = "spring", uses = {})
public interface PaymentMethodMapper {
    PaymentMethodModel toModel(PaymentMethodEntity entity);
    PaymentMethodEntity toEntity(PaymentMethodModel model);
}
