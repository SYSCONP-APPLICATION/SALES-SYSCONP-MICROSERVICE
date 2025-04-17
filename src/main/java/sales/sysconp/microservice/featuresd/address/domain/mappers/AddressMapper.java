package sales.sysconp.microservice.featuresd.address.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.features.address.application.dto.AddressResponseDTO;
import sales.sysconp.microservice.features.address.domain.models.AddressModel;
import sales.sysconp.microservice.features.address.infrastructure.entities.AddressEntity;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mapping(target = "client.contacts", ignore = true)
    @Mapping(target = "client.sales", ignore = true)
    @Mapping(target = "client.address", ignore = true)
    @Mapping(target = "client.company", ignore = true)
    @Mapping(target = "client.properties", ignore = true)
    AddressModel toModel(AddressEntity addressEntity);
    AddressEntity toEntity(AddressModel addressModel);
    AddressResponseDTO toResponseDTO(AddressModel addressModel);
}