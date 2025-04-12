package sales.sysconp.microservice.features.bank.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.features.bank.application.dto.BankResponseDTO;
import sales.sysconp.microservice.features.bank.domain.models.BankModel;
import sales.sysconp.microservice.features.bank.infrastructure.entities.BankEntity;
import sales.sysconp.microservice.modules.auth.company.domain.mapper.CompanyMapper;

@Mapper(componentModel = "spring", uses = { CompanyMapper.class })
public interface BankMapper {
    @Mapping(target = "payments", ignore = true)
    BankModel toModel(BankEntity entity);
    BankEntity toEntity(BankModel model);
    BankResponseDTO toResponseDTO(BankModel model);
}
