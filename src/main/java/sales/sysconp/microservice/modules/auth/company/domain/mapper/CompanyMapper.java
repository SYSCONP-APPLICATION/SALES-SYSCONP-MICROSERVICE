package sales.sysconp.microservice.modules.auth.company.domain.mapper;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.auth.company.application.dto.CompanyResponseDTO;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyModel toModel(CompanyEntity entity);
    CompanyEntity toEntity(CompanyModel model);

    CompanyResponseDTO toResponseDTO(CompanyModel model);
}
