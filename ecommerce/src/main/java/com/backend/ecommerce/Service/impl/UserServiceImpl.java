package com.backend.ecommerce.Service.impl;

import com.backend.ecommerce.Entity.Users;
import com.backend.ecommerce.Service.UserService;
import com.backend.ecommerce.repository.UserRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRespository userRespository;

    @Override
    public Users createUser(Users users) {
        return userRespository.save(users);
    }

    @Override
    public Users getUserById(Long Id) {
        Optional<Users> IdV = userRespository.findById(Id);
        return IdV.get();

    }

    @Override
    public List<Users> getAllusersList() {
       return userRespository.findAll();
    }

    @Override
    public Users UpdateUserById(Users users) {
        Users userV = userRespository.findById(users.getId()).get();
        userV.setFirstName(users.getFirstName());
        userV.setLastName(users.getLastName());
        userV.setEmail(users.getEmail());
        userV.setUserid(users.getUserid());

        Users savedObject = userRespository.save(userV);
        return  savedObject;
    }
}
