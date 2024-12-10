package com.apis.dto_examples.Service.impl;

import com.apis.dto_examples.Entity.User;
import com.apis.dto_examples.Entity.UserDto;
import com.apis.dto_examples.Repository.UserRepository;
import com.apis.dto_examples.Service.UserService;
import com.apis.dto_examples.mapper.AutoMapperUser;
import com.apis.dto_examples.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    /*
        DTO PATTERN MANUALLY WITHOUT MODELMAPPER CLASS
     */
    @Override
    public UserDto createUser(UserDto userdto) {

        //convert UserDto to User JPA
        User user = UserMapper.maptoUser(userdto);
        User _savedUser = userRepository.save(user);
        /*
        convert User JPA to User DTO to get the response
        from jpa to dto
         */
        UserDto saveduserdto = UserMapper.maptoUserDto(_savedUser);
        return saveduserdto;
    }

    @Override
    public UserDto getUserById(Long userId) {
       Optional<User> user = userRepository.findById(userId);
       User _user1 = user.get();
        return UserMapper.maptoUserDto(_user1);
    }

    @Override
    public List<UserDto> showAllUsers() {
        List<User> _users = userRepository.findAll();
        return _users.stream().map(UserMapper::maptoUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUserById(UserDto userdto) {
        User _existingUser = userRepository.findById(userdto.getId()).get();
        _existingUser.setFirstName(userdto.getFirstName());
        _existingUser.setLastName(userdto.getLastName());
        _existingUser.setEmailVal(userdto.getEmailVal());
        _existingUser.setRole(userdto.getRole());
        User user = userRepository.save(_existingUser);
        return UserMapper.maptoUserDto(user);
    }

    /*
        END OF DTO PATTERN MANUALLY WITHOUT MODELMAPPER CLASS
     */


    /*
       START OF DTO PATTERN  WITH MODELMAPPER CLASS
     */

    @Override
    public UserDto createUsers2(UserDto userDto){
        User user = modelMapper.map(userDto,User.class);
        User _savedUser = userRepository.save(user);
        UserDto _userDtoSaved = modelMapper.map(_savedUser,UserDto.class);
        //second approach
        UserDto _userDto2 = AutoMapperUser.MAPPER.maptoUserDto(_savedUser);
        return _userDtoSaved;
    }

    @Override
    public UserDto findUserById(Long userId) {
        Optional<User> _userid = userRepository.findById(userId);
        User _user = _userid.get();
        //second approach
        //return AutoMapperUser.MAPPER.maptoUserDto(_user);
        return modelMapper.map(_user,UserDto.class);
    }

    @Override
    public UserDto updateUsersInfo(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).get();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmailVal(userDto.getEmailVal());
        user.setRole(userDto.getRole());
        User savedUser = userRepository.save(user);
        //second approach
        //return AutoMapperUser.MAPPER.maptoUserDto(user);
        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public List<UserDto> showAllUsersData() {
        List<User> users = userRepository.findAll();
       return users.stream().map((user)->modelMapper.
               map(user,UserDto.class)).collect(Collectors.toList());
       //second approach
//        return users.stream().map((user)->AutoMapperUser.MAPPER.maptoUserDto(user))
//                .collect(Collectors.toList());
    }
}
