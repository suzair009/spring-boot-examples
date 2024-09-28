package net.java.example.springboot_rest_api.controller;

import net.java.example.springboot_rest_api.bean.employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//*****Basic Example of REST APIS in SpringBoot****

@RestController
@RequestMapping("employees")
public class employeeController {


    @GetMapping("employee")
    public ResponseEntity<employee> getemployeeList(){
        employee emp = new employee(
                101,"Syed","Uzair"
        );

        return ResponseEntity.ok().header(
                "custom-header","syed").body(emp);
    }


    public ResponseEntity<List<employee>> shooEmployeeList(){
        List<employee> emp = new ArrayList<>();
        emp.add(new employee(1,"syed","uzair"));
        emp.add(new employee(2,"syed","uzair"));
        emp.add(new employee(3,"syed","uzair"));
        emp.add(new employee(4,"syed","uzair"));

        return  ResponseEntity.ok(emp);
    }

    @GetMapping("{id}/{firstname}/{lastname}")
    public ResponseEntity<employee> showemployeeList(@PathVariable("id") int empid,
                                                     @PathVariable("firstname") String firstname,
                                                     @PathVariable("lastname") String lastname){

        employee emp = new employee(empid,firstname,lastname);
        return ResponseEntity.ok(emp);

    }

    @GetMapping("query")
    public ResponseEntity<employee> getEmployeeList(@RequestParam int emppid,@RequestParam String firstname,
                                    @RequestParam String lastname){
        employee empid = new employee(emppid,firstname,lastname);
        return  ResponseEntity.ok(empid);
    }

    @PostMapping("created")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<employee> createemployee(@RequestBody employee empid){
          System.out.println(empid.getId());
          System.out.println(empid.getFirstname());
          System.out.println(empid.getLastname());

          return new ResponseEntity<>(empid,HttpStatus.CREATED);
    }

    @PutMapping("{id}/update")
    public ResponseEntity<employee> updatedemployees(@RequestBody employee emp,@PathVariable("id") int employeeid){
        System.out.println(emp.getId());
        System.out.println(emp.getFirstname());
        System.out.println(emp.getLastname());

        return ResponseEntity.ok(emp);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteemployee(@PathVariable("id") int employeeid){
        System.out.println(employeeid);

        return ResponseEntity.ok("Student has been deleted...");
    }
}
