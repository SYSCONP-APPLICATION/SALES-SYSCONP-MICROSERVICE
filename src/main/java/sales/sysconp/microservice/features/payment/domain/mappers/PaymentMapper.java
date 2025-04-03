package sales.sysconp.microservice.features.payment.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.payment.domain.models.PaymentModel;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentModel toModel(PaymentEntity entity);
    PaymentEntity toEntity(PaymentModel model);
}
