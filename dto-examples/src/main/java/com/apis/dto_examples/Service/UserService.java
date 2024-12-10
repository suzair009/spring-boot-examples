package com.apis.dto_examples.Service;

import com.apis.dto_examples.Entity.UserDto;

import java.util.List;

public interface UserService {

    /*
        Mapping function with manual DTO
     */

    UserDto createUser(UserDto userdto);

    UserDto getUserById(Long userId);

    List<UserDto> showAllUsers();

    UserDto updateUserById(UserDto userdto);

    /*
        Mapping function with ModelMapper class
     */

    UserDto createUsers2(UserDto userDto);

    UserDto findUserById(Long userId);

    UserDto updateUsersInfo(UserDto userDto);

    List<UserDto> showAllUsersData();

}
