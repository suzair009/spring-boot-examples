package com.ems.beta.app_ems.Controller;

import com.ems.beta.app_ems.Entity.Employees;
import com.ems.beta.app_ems.Entity.User;
import com.ems.beta.app_ems.Repository.EmployeeRepository;
import com.ems.beta.app_ems.Service.EmpService;
import com.ems.beta.app_ems.Service.Imp.EmpServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private EmployeeRepository employeeRepository;

    private final EmpServiceImpl empServiceImpl;

    @Autowired
    public EmpController(EmpServiceImpl employeeService) {
        this.empServiceImpl = employeeService;
    }




    @PostMapping("/createEmployees")
    public ResponseEntity<List<Employees>> createEmployee(@RequestBody List<Employees> empVal){
        List<Employees> emp = empService.createEmployee(empVal);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable("Id") Long empId){
        Employees emp = empService.getOrderById(empId);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @PostMapping("/createEmployeeWithUser")
    public ResponseEntity<Employees> createEmployeeWithUser(@RequestBody Employees emp, @RequestParam String userNAME){

        Random random = new Random();
        int randomNumber = random.nextInt(100);

        User user = new User();
        user.setUserName(userNAME);
        user.setUserId(userNAME+"_"+randomNumber);
        user.setPassword("abc"+"@"+randomNumber);

        Employees employeeCreated  = empService.createEmployeeWithUser(emp,user);
        return new ResponseEntity<>(emp,HttpStatus.OK);

    }

    @PostMapping("/empcreateDepart")
    public ResponseEntity<Employees> empcreateDepart(@RequestBody Employees emp,
                                                     @RequestParam Long DeptId){

        Employees employees = empService.createEmployeeWithDepartment(emp,DeptId);
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @PostMapping("/emp/{empId}/projects/{projectId}")
    public ResponseEntity<Employees> createEmpWithProjects(@PathVariable("empId") Long empId,
                                                           @PathVariable("projectId") Long projectId){
        Employees bindEmployee = empService.createEmployeeToProject(empId,projectId);
        return ResponseEntity.ok(bindEmployee);
    }


    @GetMapping("/AllEmpData")
    public List<String> getFirstNameAndLastName() {
        return empServiceImpl.findFirstNameAndLastName();
    }

    @GetMapping("/empbyId/{Id}")
    public List<String> getfirstAndLastNameById(@PathVariable("Id") Long Id){
        return empServiceImpl.getFirstAndLastNameById(Id);
    }

    @GetMapping("multipleQuery/{userId}")
    public ResponseEntity<List<Map<String,Object>>> getDataQuerySelector(@PathVariable("userId") String userId){

        List<Map<String,Object>> mapValues = empServiceImpl.getQuerySelector(userId);
        return ResponseEntity.ok(mapValues);
    }

    @GetMapping("fetchData/{userId}/DeptId/{deptId}")
    public ResponseEntity<List<Map<String,Object>>> fetchOverallData(@PathVariable("userId") String userId,
                                                                     @PathVariable("deptId") Long deptId){
        List<Map<String,Object>> mapValues = empServiceImpl.fetchOverallData(userId,deptId);
        return ResponseEntity.ok(mapValues);
    }

    @GetMapping("fetchSubQury/{userId}/DeptId/{deptId}/amount/{amount}")
    public ResponseEntity<List<Map<String,Object>>> getSubQueryData(@PathVariable("userId") String userId,
                                                                    @PathVariable("deptId") Long deptId,
                                                                    @PathVariable("amount") Long amount){
        List<Map<String,Object>> _values = empServiceImpl.getSubQueryData(userId,deptId,amount);
        return ResponseEntity.ok(_values);
    }

}
