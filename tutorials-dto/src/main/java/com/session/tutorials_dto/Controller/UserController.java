package com.session.tutorials_dto.Controller;

import com.session.tutorials_dto.Entity.User;
import com.session.tutorials_dto.Repository.UserRepository;
import com.session.tutorials_dto.Service.UserService;
import com.session.tutorials_dto.Service.impl.UserServiceImpl;
import com.session.tutorials_dto.dto.Userdto;
import com.session.tutorials_dto.exceptions.EmailAlreadyExceptionExist;
import com.session.tutorials_dto.exceptions.ErrorDetails;
import com.session.tutorials_dto.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(
        name="CRUD REST APIS for User Resource",
        description = "Basic RESTAPI use for create user,update,delete,get all users"
)
@RestController
@AllArgsConstructor
@RequestMapping("/apis")
public class UserController {

    /*
        swagger url
        /swagger-ui/index.html
     */


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Operation(
            summary = "Create User",
            description = "This function uses to create users"
    )

    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping("/savedUsers")
    public ResponseEntity<Userdto> createUsers(@RequestBody @Valid  Userdto userdto){

    Optional<User> optionalUser = userRepository.findByEmail(userdto.getEmail());
    if(optionalUser.isPresent()){
        throw new EmailAlreadyExceptionExist("Email Already Exist!!!");
    }
        Userdto _savedUser = userService.createUsers(userdto);
       return new ResponseEntity<>(_savedUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User",
            description = "This function uses to Get user Data"
    )

    @ApiResponse(
            responseCode = "202",
            description = "HTTP Status 201 Get"
    )

    @GetMapping("userId/{Id}")
    public ResponseEntity<Userdto> getUserById(@PathVariable("Id") Long userId){
        Userdto userdto = userService.getUserById(userId);
        return ResponseEntity.ok(userdto);
    }

    @Operation(
            summary = "Update User",
            description = "This function uses to update users"
    )

    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )

    @PutMapping("/update/userId/{Id}")
    public ResponseEntity<Userdto> updateUserById(@RequestBody @Valid  Userdto userdto,
                                                  @PathVariable("Id") Long userId){
        userdto.setId(userId);
        Userdto _updateUser = userService.updateUserById(userdto);
        return ResponseEntity.ok(_updateUser);
    }

    @Operation(
            summary = "Show Users",
            description = "This function uses to List All users"
    )

    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )

    @GetMapping("/showAllUsers")
    public ResponseEntity<List<Userdto>> showAllUsers(){
        List<Userdto> userdto = userService.showAllUsers();
        return ResponseEntity.ok(userdto);
    }

    @Operation(
            summary = "Get Data By Email",
            description = "Custom JPQL Method"
    )

    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Getter"
    )

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
