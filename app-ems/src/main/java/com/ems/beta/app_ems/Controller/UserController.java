package com.ems.beta.app_ems.Controller;

import com.ems.beta.app_ems.Entity.User;
import com.ems.beta.app_ems.Service.Imp.UserServiceImpl;
import com.ems.beta.app_ems.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceimpl;

    @PostMapping("/createusers")
    public ResponseEntity<User> createUsers(@RequestBody  User user){
        User users = userService.createBulkUser(user);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @GetMapping("{Id}")
    public ResponseEntity<User> getOrderById(@PathVariable("Id") Long Id){
        User userV = userService.getByUserId(Id);
        return new ResponseEntity<>(userV,HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUserByEmployee(@RequestParam Long empId,@RequestBody User user){
        User _user  = userService.getDataByEmployeeId(empId,user);
        return new ResponseEntity<>(_user,HttpStatus.OK);
    }

    @GetMapping("/showQueryUsers")
    public ResponseEntity<List<String>> getUsersbyQuery(){
        return new ResponseEntity<>(userServiceimpl.getUsersAllDataByQuery(),HttpStatus.OK);
    }

    @GetMapping("userwithName/{username}")
    public ResponseEntity<List<Map<String,Object>>> getUsersWithName(@PathVariable("username") String username){
        List<Map<String,Object>> mapVal = userServiceimpl.getUsersDatabyName(username);
       return ResponseEntity.ok(mapVal);
    }

}
