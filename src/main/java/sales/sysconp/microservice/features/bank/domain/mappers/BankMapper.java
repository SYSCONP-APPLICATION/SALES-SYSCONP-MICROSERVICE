package sales.sysconp.microservice.features.bank.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.bank.domain.models.BankModel;
import sales.sysconp.microservice.features.bank.infrastructure.entities.BankEntity;

@Mapper(componentModel = "spring", uses = {})
public interface BankMapper {
    BankModel toModel(BankEntity entity);
    BankEntity toEntity(BankModel model);
}
