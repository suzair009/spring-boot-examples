package com.basics.thymeleaf.Controller;

import com.basics.thymeleaf.Model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("expression/")
public class ThyemeleafIntro {

    @GetMapping("/intro")
    public String introPage(Model model){
        model.addAttribute("message","Welcome to Thymeleaf World!!!");
        return "intro-page";
    }

    @GetMapping("/variable-expression")
    public String varExpression(@RequestParam Long empId, Model model){
        Employee emp = new Employee(empId,"Syed","Uzair","uzair@gmail.com","ADMIN");
        model.addAttribute("employee",emp);
        return "variable-expression";
    }

    @GetMapping("/select-expression")
    public String selectExpress(Model model){
        Employee emp = new Employee(101L,"Syed","Uzair","uzair@gmail.com","ADMIN");
        model.addAttribute("employee",emp);
        return "select-expression";
    }

    @GetMapping("/link-expression")
    public  String linkexpression(Model model){
        Long empId  = 101L;
        model.addAttribute("Id",empId);
        return "link-expression";
    }

    @GetMapping("/fragments-expression")
    public String fragmentExpress(Model model){
        return "fragments-expression";
    }

    @GetMapping("/reportdata")
    public String showReport(Model model){
        Employee emp1 = new Employee(101L,"FirstName1","LastName1","employee1@gmail.com","ADMIN");
        Employee emp2 = new Employee(102L,"FirstName2","LastName2","employee2@gmail.com","ADMIN");
        Employee emp3 = new Employee(103L,"FirstName3","LastName3","employee3@gmail.com","USER");
        Employee emp4 = new Employee(104L,"FirstName4","LastName4","employee4@gmail.com","USER");
        Employee emp5 = new Employee(105L,"FirstName5","LastName5","employee5@gmail.com","USER");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        employeeList.add(emp5);

        model.addAttribute("employee",employeeList);
        return "EmployeeReport";
    }

    @GetMapping("/conditional-expression")
    public String condtExpression(Model model){
        Employee emp1 = new Employee(101L,"FirstName1","LastName1","employee1@gmail.com","ADMIN");
        Employee emp2 = new Employee(102L,"FirstName2","LastName2","employee2@gmail.com","ADMIN");
        Employee emp3 = new Employee(103L,"FirstName3","LastName3","employee3@gmail.com","USER");
        Employee emp4 = new Employee(104L,"FirstName4","LastName4","employee4@gmail.com","USER");
        Employee emp5 = new Employee(105L,"FirstName5","LastName5","employee5@gmail.com","USER");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        employeeList.add(emp5);

        model.addAttribute("employee",employeeList);
        return "conditional-expression";

    }

    @GetMapping("/switch-expression")
    public String switchExpression(Model model){
        Employee emp1 = new Employee(101L,"FirstName1","LastName1","employee1@gmail.com","ADMIN");
        Employee emp2 = new Employee(102L,"FirstName2","LastName2","employee2@gmail.com","ADMIN");
        Employee emp3 = new Employee(103L,"FirstName3","LastName3","employee3@gmail.com","USER");
        Employee emp4 = new Employee(104L,"FirstName4","LastName4","employee4@gmail.com","USER");
        Employee emp5 = new Employee(105L,"FirstName5","LastName5","employee5@gmail.com","USER");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        employeeList.add(emp5);

        model.addAttribute("employee",employeeList);
        return "switch-expression";
    }
}
