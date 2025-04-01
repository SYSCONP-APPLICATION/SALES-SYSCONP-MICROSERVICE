package sales.sysconp.microservice.modules.auth.user.domain.mappers;

import org.mapstruct.Mapper;
import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserModel toModel(UserEntity entity);
    UserEntity toEntity(UserModel model);
}