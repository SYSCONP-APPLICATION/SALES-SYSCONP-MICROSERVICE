package sales.sysconp.microservice.modules.auth.user.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserResponseDTO;
import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "company", ignore = true)
    UserModel toModel(UserEntity entity);

    UserEntity toEntity(UserModel model);

    UserResponseDTO toResponseDTO(UserModel model);
}