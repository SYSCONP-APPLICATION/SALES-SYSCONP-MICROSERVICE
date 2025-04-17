package sales.sysconp.microservice.config.features.installment.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentResponseDTO;
import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;

@Mapper(componentModel = "spring")
public interface InstallmentMapper {
    @Mapping(target = "sale", ignore = true)
    InstallmentModel toModel(InstallmentEntity entity);
    InstallmentEntity toEntity(InstallmentModel model);
    InstallmentResponseDTO toResponseDTO(InstallmentModel installmentModel);
}