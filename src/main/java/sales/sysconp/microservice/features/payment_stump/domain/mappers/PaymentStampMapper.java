package sales.sysconp.microservice.features.payment_stump.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.payment_stump.domain.models.PaymentStampModel;
import sales.sysconp.microservice.features.payment_stump.infrastructure.entities.PaymentStampEntity;

@Mapper(componentModel = "spring", uses = {})
public interface PaymentStampMapper {
    PaymentStampModel toModel(PaymentStampEntity entity);
    PaymentStampEntity toEntity(PaymentStampModel model);
}