package com.session.tutorials_dto.Service.impl;

import com.session.tutorials_dto.Entity.User;
import com.session.tutorials_dto.Repository.UserRepository;
import com.session.tutorials_dto.Service.UserService;
import com.session.tutorials_dto.dto.Userdto;
import com.session.tutorials_dto.exceptions.ResourceNotFoundException;
import com.session.tutorials_dto.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Userdto createUsers(Userdto userdto) {
        //convert DTO to JPA
        User user = UserMapper.maptoUser(userdto);
        User _savedUsers = userRepository.save(user);
        //JPA TO DTO
        Userdto _userSavedDto = UserMapper.maptoUserDto(_savedUsers);
        return _userSavedDto;
    }

    @Override
    public Userdto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User","Id",userId)
        );
        return UserMapper.maptoUserDto(user);
    }

    @Override
    public Userdto updateUserById(Userdto userdto) {
        User _existingUser = userRepository.findById(userdto.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User","Id",userdto.getId())
        );

        _existingUser.setFirstName(userdto.getFirstName());
        _existingUser.setLastName(userdto.getLastName());
        _existingUser.setEmail(userdto.getEmail());
        _existingUser.setRole(userdto.getRole());

        User savedUser = userRepository.save(_existingUser);
        return UserMapper.maptoUserDto(savedUser);
    }

    @Override
    public List<Userdto> showAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::maptoUserDto).collect(Collectors.toList());
    }

    @Override
    public List<Map<String,Object>> getDataByEmail(String emailId){

        List<Object[]> dataValues = userRepository.findBycustomEmail(emailId);
        if(dataValues.isEmpty()){
            throw new ResourceNotFoundException("User","Value: "+emailId,101L);
        }
        List<Map<String,Object>> response  = dataValues.stream().map(records->{
            Map<String,Object> _values = new HashMap<>();
            _values.put("firstName",records[0]);
            _values.put("lastName",records[1]);
            _values.put("email",records[2]);
            _values.put("roleString",records[3]);
            return _values;
        }).toList();

        return response;
    }


}
