package com.basics.thymeleaf.Controller;

import com.basics.thymeleaf.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserFormController {

    //handler request to handle page request
    @GetMapping("/register")
    public String useForm(Model model){
        User user = new User();
        model.addAttribute("userform",user);

        List<String> listProfession = Arrays.asList("Developer","Tester","Project Manager","Architecht");
        model.addAttribute("listProfession",listProfession);

        return "user-register";
    }

    //handler request to submit page request
    @PostMapping("/register/save")
    public String postForm(Model model, @ModelAttribute User user){
        model.addAttribute("userform",user);
        return "register-submit";
    }
}
