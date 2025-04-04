package sales.sysconp.microservice.modules.auth.user.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sales.sysconp.microservice.modules.auth.user.application.dto.UserResponseDTO;
import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "company.users", ignore = true)
    UserModel toModel(UserEntity entity);

    @Mapping(target = "company.users", ignore = true)
    UserEntity toEntity(UserModel model);

    @Mapping(target = "company.users", ignore = true)
    UserResponseDTO toResponseDTO(UserModel model);
}