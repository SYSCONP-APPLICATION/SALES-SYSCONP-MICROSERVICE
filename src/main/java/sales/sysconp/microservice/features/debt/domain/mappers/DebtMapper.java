package sales.sysconp.microservice.features.debt.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.debt.application.dto.DebtResponseDTO;
import sales.sysconp.microservice.features.debt.domain.models.DebtModel;
import sales.sysconp.microservice.features.debt.infrastructure.entities.DebtEntity;
import sales.sysconp.microservice.features.installment.domain.mappers.InstallmentMapper;

@Mapper(componentModel = "spring", uses = { InstallmentMapper.class })
public interface DebtMapper {
    DebtModel toModel(DebtEntity entity);

    DebtEntity toEntity(DebtModel model);

    DebtResponseDTO toResponseDTO(DebtModel model);
}
