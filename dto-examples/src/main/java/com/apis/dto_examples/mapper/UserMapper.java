package com.apis.dto_examples.mapper;

import com.apis.dto_examples.Entity.User;
import com.apis.dto_examples.Entity.UserDto;

public class UserMapper {

    //convert User JPA Entity to User DTO
    public static UserDto maptoUserDto(User user){
        UserDto _userDTO = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmailVal(),
                user.getRole()
        );

        return _userDTO;
    }

    //Covert User DTO to User JPA Entity

    public static User maptoUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmailVal(),
                userDto.getRole()
        );

        return user;
    }
}
