package sales.sysconp.microservice.features.sale.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.features.client.domain.mappers.ClientMapper;
import sales.sysconp.microservice.features.installment.domain.mappers.InstallmentMapper;
import sales.sysconp.microservice.features.sale.application.dto.SaleResponseDTO;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;
import sales.sysconp.microservice.modules.auth.company.domain.mapper.CompanyMapper;
import sales.sysconp.microservice.modules.auth.user.domain.mappers.UserMapper;
import sales.sysconp.microservice.modules.project.unity.domain.mappers.UnityMapper;

@Mapper(componentModel = "spring", uses = { ClientMapper.class, CompanyMapper.class, UserMapper.class, UnityMapper.class, InstallmentMapper.class })
public interface SaleMapper {
    @Mapping(target = "payments", ignore = true)
    @Mapping(target = "paymentConfiguration.sale", ignore = true)
    @Mapping(target = "installments", ignore = true)
    SaleModel toModel(SaleEntity entity);

    SaleEntity toEntity(SaleModel model);
    SaleResponseDTO toResponseDTO(SaleModel model);
}