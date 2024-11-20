package com.ems.beta.app_ems.Service.Imp;

import com.ems.beta.app_ems.Entity.Employee;
import com.ems.beta.app_ems.Entity.User;
import com.ems.beta.app_ems.Repository.EmployeeRepository;
import com.ems.beta.app_ems.Repository.UserRepository;
import com.ems.beta.app_ems.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public User createBulkUser(User users) {
        return userRepository.save(users);
    }

    @Override
    public User getByUserId(Long userid) {
        return userRepository.findById(userid).get();
    }

    @Override
    public User getDataByEmployeeId(Long Id, User user) {
        Employee emp = employeeRepository.findById(Id).get();
        //Associate the Emloyee with User
        user.setUserName(user.getUserName());
        user.setPassword(user.getPassword()+"@"+Id);
        user.setUserId(user.getUserId());
        user.setEmployee(emp);
        return userRepository.save(user);
    }
}
