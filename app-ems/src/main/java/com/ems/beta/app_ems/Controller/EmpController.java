package com.ems.beta.app_ems.Controller;

import com.ems.beta.app_ems.Entity.Department;
import com.ems.beta.app_ems.Entity.Employee;
import com.ems.beta.app_ems.Entity.User;
import com.ems.beta.app_ems.Repository.EmployeeRepository;
import com.ems.beta.app_ems.Service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private EmployeeRepository employeeRepository;



    @PostMapping("/createEmployees")
    public ResponseEntity<List<Employee>> createEmployee(@RequestBody List<Employee> empVal){
        List<Employee> emp = empService.createEmployee(empVal);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("Id") Long empId){
        Employee emp = empService.getOrderById(empId);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @PostMapping("/createEmployeeWithUser")
    public ResponseEntity<Employee> createEmployeeWithUser(@RequestBody Employee emp,@RequestParam String userNAME){

        Random random = new Random();
        int randomNumber = random.nextInt(100);

        User user = new User();
        user.setUserName(userNAME);
        user.setUserId(userNAME+"_"+randomNumber);
        user.setPassword("abc"+"@"+randomNumber);

        Employee employeeCreated  = empService.createEmployeeWithUser(emp,user);
        return new ResponseEntity<>(emp,HttpStatus.OK);

    }

    @PostMapping("/empcreateDepart")
    public ResponseEntity<Employee> empcreateDepart(@RequestBody Employee emp,
                                                          @RequestParam Long DeptId){

        Employee employees = empService.createEmployeeWithDepartment(emp,DeptId);
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @PostMapping("/emp/{empId}/projects/{projectId}")
    public ResponseEntity<Employee> createEmpWithProjects(@PathVariable("empId") Long empId,
                                                          @PathVariable("projectId") Long projectId){
        Employee bindEmployee = empService.createEmployeeToProject(empId,projectId);
        return ResponseEntity.ok(bindEmployee);
    }



}
