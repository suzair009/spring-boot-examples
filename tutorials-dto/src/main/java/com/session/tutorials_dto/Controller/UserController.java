package com.session.tutorials_dto.Controller;

import com.session.tutorials_dto.Entity.User;
import com.session.tutorials_dto.Repository.UserRepository;
import com.session.tutorials_dto.Service.UserService;
import com.session.tutorials_dto.Service.impl.UserServiceImpl;
import com.session.tutorials_dto.dto.Userdto;
import com.session.tutorials_dto.exceptions.EmailAlreadyExceptionExist;
import com.session.tutorials_dto.exceptions.ErrorDetails;
import com.session.tutorials_dto.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/apis")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;



    @PostMapping("/savedUsers")
    public ResponseEntity<Userdto> createUsers(@RequestBody @Valid  Userdto userdto){

    Optional<User> optionalUser = userRepository.findByEmail(userdto.getEmail());
    if(optionalUser.isPresent()){
        throw new EmailAlreadyExceptionExist("Email Already Exist!!!");
    }
        Userdto _savedUser = userService.createUsers(userdto);
       return new ResponseEntity<>(_savedUser, HttpStatus.CREATED);
    }

    @GetMapping("userId/{Id}")
    public ResponseEntity<Userdto> getUserById(@PathVariable("Id") Long userId){
        Userdto userdto = userService.getUserById(userId);
        return ResponseEntity.ok(userdto);
    }

    @PutMapping("/update/userId/{Id}")
    public ResponseEntity<Userdto> updateUserById(@RequestBody @Valid  Userdto userdto,
                                                  @PathVariable("Id") Long userId){
        userdto.setId(userId);
        Userdto _updateUser = userService.updateUserById(userdto);
        return ResponseEntity.ok(_updateUser);
    }

    @GetMapping("/showAllUsers")
    public ResponseEntity<List<Userdto>> showAllUsers(){
        List<Userdto> userdto = userService.showAllUsers();
        return ResponseEntity.ok(userdto);
    }

    @GetMapping("/emailId/{email}")
    public ResponseEntity<List<Map<String,Object>>> getDataByEmailId(@PathVariable("email") String emailId){
        List<Map<String,Object>> response = userService.getDataByEmail(emailId);
        return ResponseEntity.ok(response);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundExcepton(ResourceNotFoundException exception,
//                                                                       WebRequest request){
//        ErrorDetails errorDetails = new ErrorDetails(
//          LocalDateTime.now(),
//                exception.getMessage(),
//                request.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }

}
