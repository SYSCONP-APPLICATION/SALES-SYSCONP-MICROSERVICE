package sales.sysconp.microservice.features.sale.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.client.domain.mappers.ClientMapper;
import sales.sysconp.microservice.features.sale.application.dto.SaleResponseDTO;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;
import sales.sysconp.microservice.modules.auth.company.domain.mapper.CompanyMapper;
import sales.sysconp.microservice.modules.auth.user.domain.mappers.UserMapper;
import sales.sysconp.microservice.modules.project.unity.domain.mappers.UnityMapper;

@Mapper(componentModel = "spring", uses = { CompanyMapper.class, ClientMapper.class, UserMapper.class, UnityMapper.class })
public interface SaleMapper {
    SaleModel toModel(SaleEntity entity);
    SaleEntity toEntity(SaleModel model);
    SaleResponseDTO toResponseDTO(SaleModel model);
}
