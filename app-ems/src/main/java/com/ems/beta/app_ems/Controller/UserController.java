package com.ems.beta.app_ems.Controller;

import com.ems.beta.app_ems.Entity.Employee;
import com.ems.beta.app_ems.Entity.User;
import com.ems.beta.app_ems.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

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

}
