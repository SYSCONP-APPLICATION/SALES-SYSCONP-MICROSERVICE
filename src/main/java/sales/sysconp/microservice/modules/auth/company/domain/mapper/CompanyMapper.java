package sales.sysconp.microservice.modules.auth.company.domain.mapper;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;

@Mapper(componentModel = "spring", uses = { })
public interface CompanyMapper {
    CompanyModel toModel(CompanyEntity entity);
    CompanyEntity toEntity(CompanyModel model);
}
