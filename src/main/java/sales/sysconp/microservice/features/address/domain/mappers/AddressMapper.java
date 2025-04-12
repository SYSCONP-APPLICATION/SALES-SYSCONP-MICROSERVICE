package sales.sysconp.microservice.features.address.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.address.domain.models.AddressModel;
import sales.sysconp.microservice.features.address.infrastructure.entities.AddressEntity;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressModel toModel(AddressEntity addressEntity);
    AddressEntity toEntity(AddressModel addressModel);
}
