package sales.sysconp.microservice.features.installment.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentResponseDTO;
import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;

@Mapper(componentModel = "spring")
public interface InstallmentMapper {
    @Mapping(target = "sale", ignore = true)
    @Mapping(target = "debt.installment", ignore = true) // já está aqui e correto
    @Mapping(target = "payments", ignore = true)
    InstallmentModel toModel(InstallmentEntity entity);

    @Mapping(target = "sale", ignore = true)
    @Mapping(target = "debt.installment", ignore = true) // <-- ADICIONE AQUI!
    @Mapping(target = "payments", ignore = true)
    InstallmentEntity toEntity(InstallmentModel model);

    InstallmentResponseDTO toResponseDTO(InstallmentModel installmentModel);
}