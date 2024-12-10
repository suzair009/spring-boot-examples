package com.apis.dto_examples.mapper;

import com.apis.dto_examples.Entity.User;
import com.apis.dto_examples.Entity.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoMapperUser {

    AutoMapperUser MAPPER = Mappers.getMapper(AutoMapperUser.class);

    UserDto maptoUserDto(User user);

    User maptoUser(UserDto userDto);
}
