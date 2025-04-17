package sales.sysconp.microservice.config.modules.auth.company.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyResponseDTO;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "projects", ignore = true)
    @Mapping(target = "propertyCategories", ignore = true)
    @Mapping(target = "sales", ignore = true)
    @Mapping(target = "payments", ignore = true)
    @Mapping(target = "paymentMethods", ignore = true)
    @Mapping(target = "clients", ignore = true)
    @Mapping(target = "banks", ignore = true)
    @Mapping(target = "systemPaymentConfiguration.company", ignore = true)
    CompanyModel toModel(CompanyEntity entity);

    CompanyEntity toEntity(CompanyModel model);

    CompanyResponseDTO toResponseDTO(CompanyModel model);
}
