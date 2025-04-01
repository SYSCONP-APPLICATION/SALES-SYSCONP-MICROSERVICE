package sales.sysconp.microservice.features.contact.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.contact.domain.models.ContactModel;
import sales.sysconp.microservice.features.contact.infrastructure.entities.ContactEntity;

@Mapper(componentModel = "spring", uses = {})
public interface ContactMapper {
    ContactModel toModel(ContactEntity entity);
    ContactEntity toEntity(ContactModel model);
}