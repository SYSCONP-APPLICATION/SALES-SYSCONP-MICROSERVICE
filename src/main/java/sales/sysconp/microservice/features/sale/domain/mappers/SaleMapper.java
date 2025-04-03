package sales.sysconp.microservice.features.sale.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;

@Mapper(componentModel = "spring")
public interface SaleMapper {
    SaleModel toModel(SaleEntity entity);
    SaleEntity toEntity(SaleModel model);
}
