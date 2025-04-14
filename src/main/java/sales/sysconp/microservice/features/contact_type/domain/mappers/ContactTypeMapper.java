package sales.sysconp.microservice.features.contact_type.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.features.contact_type.application.dto.ContactTypeResponseDTO;
import sales.sysconp.microservice.features.contact_type.domain.models.ContactTypeModel;
import sales.sysconp.microservice.features.contact_type.infrastructure.entities.ContactTypeEntity;

@Mapper(componentModel = "spring")
public interface ContactTypeMapper {
    @Mapping(target = "contacts", ignore = true)
    ContactTypeModel toModel(ContactTypeEntity entity);
    ContactTypeEntity toEntity(ContactTypeModel model);
    ContactTypeResponseDTO toResponseDTO(ContactTypeModel model);
}