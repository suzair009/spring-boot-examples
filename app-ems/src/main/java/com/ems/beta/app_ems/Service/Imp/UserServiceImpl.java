package com.ems.beta.app_ems.Service.Imp;

import com.ems.beta.app_ems.Entity.Employees;
import com.ems.beta.app_ems.Entity.User;
import com.ems.beta.app_ems.Repository.EmployeeRepository;
import com.ems.beta.app_ems.Repository.UserRepository;
import com.ems.beta.app_ems.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Employees emp = employeeRepository.findById(Id).get();
        //Associate the Emloyee with User
        user.setUserName(user.getUserName());
        user.setPassword(user.getPassword()+"@"+Id);
        user.setUserId(user.getUserId());
        user.setEmployee(emp);
        return userRepository.save(user);
    }

    public List<String> getUsersAllDataByQuery(){
        List<Object []> results = userRepository.getUsersDatabyQuery();
        List<String> formattedResults = new ArrayList<>();
        for(Object[] rows:results){
            String userName = (String) rows[0];
            String userId = (String) rows[1];
            formattedResults.add("UserName:"+userName+", userId"+userId);
        }
        return formattedResults;
    }

    public  List<Map<String,Object>>  getUsersDatabyName(String username){

        List<Object[]> userids = userRepository.getUsersDatabyQueryName(username);

        //convert data to a redable list of maps
        List<Map<String,Object>> response = userids.stream().map(record ->{
            Map<String,Object> map = new HashMap<>();
            map.put("username",record[0]);
            map.put("firstName",record[1]);
            return map;
        }).toList();

        return response;
    }

}
