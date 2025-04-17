package sales.sysconp.microservice.featuresd.client.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.features.address.domain.mappers.AddressMapper;
import sales.sysconp.microservice.features.client.application.dto.ClientResponseDTO;
import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;
import sales.sysconp.microservice.features.contact.domain.mappers.ContactMapper;
import sales.sysconp.microservice.modules.auth.company.domain.mapper.CompanyMapper;

@Mapper(componentModel = "spring", uses = { CompanyMapper.class, AddressMapper.class, ContactMapper.class})
public interface ClientMapper {
    @Mapping(target = "sales", ignore = true)
    @Mapping(target = "properties", ignore = true)
    ClientModel toModel(ClientEntity entity);
    ClientEntity toEntity(ClientModel model);
    ClientResponseDTO toResponseDTO(ClientModel model);
}