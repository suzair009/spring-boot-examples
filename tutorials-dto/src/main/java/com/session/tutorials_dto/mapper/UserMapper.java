package com.session.tutorials_dto.mapper;

import com.session.tutorials_dto.Entity.User;
import com.session.tutorials_dto.dto.Userdto;

public class UserMapper {

    //convert User JPA Entity to User DTO
    public static Userdto maptoUserDto(User user){
        Userdto _userDTO = new Userdto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getRole()
        );

        return _userDTO;
    }

    //Covert User DTO to User JPA Entity

    public static User maptoUser(Userdto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getRole()
        );

        return user;
    }
}
