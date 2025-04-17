package sales.sysconp.microservice.featuresd.debt.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.debt.domain.models.DebtModel;
import sales.sysconp.microservice.features.debt.infrastructure.entities.DebtEntity;

@Mapper(componentModel = "spring")
public interface DebtMapper {
    DebtModel toModel(DebtEntity entity);
    DebtEntity toEntity(DebtModel model);
}
