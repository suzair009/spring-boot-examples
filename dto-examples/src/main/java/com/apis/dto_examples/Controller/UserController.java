package com.apis.dto_examples.Controller;

import com.apis.dto_examples.Entity.User;
import com.apis.dto_examples.Entity.UserDto;
import com.apis.dto_examples.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/apis")
public class UserController {

    /*
      Controller Logic with Manual DTO Mapping
     */
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto){
        UserDto _savedUser = userService.createUser(userdto);
        return new ResponseEntity<>(_savedUser,HttpStatus.CREATED);
    }

    @GetMapping("/userId/{Id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("Id") Long userId){
        UserDto _userDto = userService.getUserById(userId);
        System.out.println(_userDto.getId());
        return new ResponseEntity<>(_userDto,HttpStatus.OK);
    }

    @GetMapping("/showAllUsers")
    public ResponseEntity<List<UserDto>> showAllUsers(){
        List<UserDto> users  = userService.showAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("updateuser/{Id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable("Id") Long userId,@RequestBody UserDto userdto){
        userdto.setId(userId);
        UserDto userDto = userService.updateUserById(userdto);
        return ResponseEntity.ok(userDto);
    }

     /*
      Controller Logic with Model Mapper class
     */

    @PostMapping("/dtos/createUser")
    public ResponseEntity<UserDto> createUsers2(@RequestBody UserDto userDto){
        UserDto userDto1 = userService.createUsers2(userDto);
        return ResponseEntity.ok(userDto1);
    }

    @GetMapping("/dtos/userId/{Id}")
    public ResponseEntity<UserDto> findByUserById(@PathVariable("Id") Long userId){
        UserDto _user = userService.getUserById(userId);
        return ResponseEntity.ok(_user);
    }

    @PutMapping("dtos/update/{Id}")
    public ResponseEntity<UserDto> updateDataByUserId(@PathVariable("Id") Long userId,
                                                      @RequestBody UserDto userDto){
        userDto.setId(userId);
        UserDto _updateUser = userService.updateUsersInfo(userDto);
        return ResponseEntity.ok(_updateUser);
    }

    @GetMapping("dtos/showAllUsers")
    public ResponseEntity<List<UserDto>> showAllUsersDto(){
        List<UserDto> userDto = userService.showAllUsersData();
        return ResponseEntity.ok(userDto);
    }
}
