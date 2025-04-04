package sales.sysconp.microservice.modules.auth.company.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyResponseDTO;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "projects", ignore = true)
    CompanyModel toModel(CompanyEntity entity);

    @Mapping(target = "users", ignore = true)
    CompanyEntity toEntity(CompanyModel model);

    @Mapping(target = "users", ignore = true)
    CompanyResponseDTO toResponseDTO(CompanyModel model);
}
