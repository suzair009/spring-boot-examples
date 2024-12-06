package com.thymeleaf.ums.Controller;

import com.thymeleaf.ums.Entity.Department;
import com.thymeleaf.ums.Entity.Role;
import com.thymeleaf.ums.Entity.User;
import com.thymeleaf.ums.Repository.DepartmentRepository;
import com.thymeleaf.ums.Repository.UserRepository;
import com.thymeleaf.ums.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


        @GetMapping("/user/register")
    public String userRegister(Model model){
        User user = new User();

        model.addAttribute("userform",user);

        List<Role> professionList = Arrays.asList(
                new Role(1,"Developer"),
                new Role(2,"Tester"),
                new Role(3,"Manager"),
                new Role(4,"Architecht")
                );

        List<Department> department = departmentRepository.findAll();
        model.addAttribute("department",department);

        model.addAttribute("listProfession",professionList);
        return "user-register";
    }

    @PostMapping("/register/save")
    public String registerSave(Model model, @ModelAttribute User user){

        Integer _myCheckBoxVal = user.getIsadmin();
        user.setIsadmin(_myCheckBoxVal==null ? 0 : 1);

        model.addAttribute("userForm",user);
        userRepository.save(user);
        return "register-submit";
    }

    @GetMapping("user/report")
    public String userReport(Model model){
        List<User> _user = userRepository.showUsersData();
        model.addAttribute("user",_user);
        return "UserReport";
    }


}
