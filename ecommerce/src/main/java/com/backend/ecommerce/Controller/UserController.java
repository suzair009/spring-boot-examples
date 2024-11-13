package com.backend.ecommerce.Controller;

import com.backend.ecommerce.Entity.Users;
import com.backend.ecommerce.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    //http://localhost:8080/api/users/createusers
    @PostMapping("/createusers")
    public ResponseEntity<Users>
    createUsers(@RequestBody Users user){
        Users users = userService.createUser(user);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Users> getUserById(@PathVariable("Id") Long Id){
        Users users  =  userService.getUserById(Id);
        return  new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("showAllUsers")
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> users = userService.getAllusersList();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("update/{Id}")
    public ResponseEntity<Users>
    updateUserById(@PathVariable Long Id,@RequestBody Users users){
        users.setId(Id);
        userService.UpdateUserById(users);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

}
