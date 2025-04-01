package sales.sysconp.microservice.features.client.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;

@Mapper(componentModel = "spring", uses = {})
public interface ClientMapper {
    ClientModel toModel(ClientEntity entity);
    ClientEntity toEntity(ClientModel model);
}
