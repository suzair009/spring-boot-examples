package com.backend.ecommerce.Service;

import com.backend.ecommerce.Entity.Users;

import java.util.List;

public interface UserService {
    Users createUser(Users users);

    Users getUserById(Long Id);

    List<Users> getAllusersList();

    Users UpdateUserById(Users users);
}
