package sales.sysconp.microservice.features.installment.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentResponseDTO;
import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;
import sales.sysconp.microservice.features.payment.domain.mappers.PaymentMapper;

@Mapper(componentModel = "spring", uses = { PaymentMapper.class })
public interface InstallmentMapper {
    @Mapping(target = "sale", ignore = true)
    @Mapping(target = "debt.installment", ignore = true)
    @Mapping(target = "installment.payments", ignore = true)
    InstallmentModel toModel(InstallmentEntity entity);

    InstallmentEntity toEntity(InstallmentModel model);

    InstallmentResponseDTO toResponseDTO(InstallmentModel installmentModel);
}