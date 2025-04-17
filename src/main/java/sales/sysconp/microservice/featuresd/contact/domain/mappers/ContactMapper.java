package sales.sysconp.microservice.featuresd.contact.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.features.contact.application.dto.ContactResponseDTO;
import sales.sysconp.microservice.features.contact.domain.models.ContactModel;
import sales.sysconp.microservice.features.contact.infrastructure.entities.ContactEntity;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    @Mapping(target = "client.contacts", ignore = true)
    @Mapping(target = "contactType.contacts", ignore = true)
    @Mapping(target = "client.sales", ignore = true)
    @Mapping(target = "client.address", ignore = true)
    @Mapping(target = "client.properties", ignore = true)
    @Mapping(target = "client.company", ignore = true)
    ContactModel toModel(ContactEntity entity);
    ContactEntity toEntity(ContactModel model);
    ContactResponseDTO toResponseDTO(ContactModel model);
}