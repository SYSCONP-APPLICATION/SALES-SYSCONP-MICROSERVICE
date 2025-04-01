package sales.sysconp.microservice.features.contact_type.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.features.contact_type.domain.models.ContactTypeModel;
import sales.sysconp.microservice.features.contact_type.infrastructure.entities.ContactTypeEntity;

@Mapper(componentModel = "spring")
public interface ContactTypeMapper {
    ContactTypeModel toModel(ContactTypeEntity entity);
    ContactTypeEntity toEntity(ContactTypeModel model);
}