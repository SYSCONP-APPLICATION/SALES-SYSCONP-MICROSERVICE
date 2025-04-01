package sales.sysconp.microservice.features.installment.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;

@Mapper(componentModel = "spring", uses = {})
public interface InstallmentMapper {
    InstallmentModel toModel(InstallmentEntity entity);
    InstallmentEntity toEntity(InstallmentModel model);
}
