package sales.sysconp.microservice.features.payment.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.features.bank.domain.mappers.BankMapper;
import sales.sysconp.microservice.features.payment.application.dto.PaymentResponseDTO;
import sales.sysconp.microservice.features.payment.domain.models.PaymentModel;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.modules.auth.company.domain.mapper.CompanyMapper;
import sales.sysconp.microservice.modules.auth.user.domain.mappers.UserMapper;

@Mapper(componentModel = "spring", uses = { BankMapper.class, CompanyMapper.class, UserMapper.class })
public interface PaymentMapper {
    @Mapping(target = "installment", ignore = true)
    @Mapping(target = "sale", ignore = true)
    @Mapping(target = "paymentMethod", ignore = true)
    PaymentModel toModel(PaymentEntity entity);

    PaymentEntity toEntity(PaymentModel model);
    PaymentResponseDTO toResponseDTO(PaymentModel model);
}