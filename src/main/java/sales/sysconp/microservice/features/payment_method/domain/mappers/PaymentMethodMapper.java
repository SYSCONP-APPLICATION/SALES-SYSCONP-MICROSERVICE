package sales.sysconp.microservice.features.payment_method.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.payment.domain.mappers.PaymentMapper;
import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodResponseDTO;
import sales.sysconp.microservice.features.payment_method.domain.models.PaymentMethodModel;
import sales.sysconp.microservice.features.payment_method.infrastructure.entities.PaymentMethodEntity;
import sales.sysconp.microservice.modules.auth.company.domain.mapper.CompanyMapper;

@Mapper(componentModel = "spring", uses = { CompanyMapper.class, PaymentMapper.class })
public interface PaymentMethodMapper {
    PaymentMethodModel toModel(PaymentMethodEntity entity);
    PaymentMethodEntity toEntity(PaymentMethodModel model);
    PaymentMethodResponseDTO toResponseDTO(PaymentMethodModel model);
}