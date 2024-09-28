package net.java.example.springboot_rest_api.controller;

import net.java.example.springboot_rest_api.bean.student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class studentController {

    @GetMapping("student")
    public student getStudent(){
       student std = new student(
             1,
             "Syed",
             "Uzair",
             "Senior Software Developer"
       );

       return std;
    }

    @GetMapping("students")
    public List<student> getStudentList(){
        List<student> std = new ArrayList<>();
        std.add(new student(1,"MichaelA","souzaA","Manager"));
        std.add(new student(2,"MichaelB","souzaB","Associate"));
        std.add(new student(3,"MichaelC","souzaC","Developer"));
        std.add(new student(4,"MichaelD","souzaD","Junior"));

        return  std;
    }

    //spring boot REST API with pat variable
    @GetMapping("getstudents/{id}")
    public student getemployeedetailsById(@PathVariable("id") int studentid){
        return new student(studentid,"Syed","Uzair","Developer");
    }

    //Spring boot Rest API with multiple parameters
    @GetMapping("multipara/{id}/{first-name}/{last-name}/{design}")
    public student getMultiplePara(@PathVariable("id") int stdid,
                                   @PathVariable("first-name") String fName,
                                   @PathVariable("last-name") String lname,
                                   @PathVariable("design") String dname){

        return new student(stdid,fName,lname,dname);
    }

    //spring boot rest api with multiple parameters for query
    //url:localhost:8080/studentsapi/query?id=1&fName=Syed&lname=Uzair&designation=developer
    @GetMapping("studentsapi/query")
    public student getqueryListStudents(@RequestParam int id,
                                        @RequestParam String fName,
                                        @RequestParam String lname,
                                        @RequestParam String designation){
        return new student(id,fName,lname,designation);
    }

    //spring boot rest api http method
    //PostMapping RequestBody

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public student createstudent(@RequestBody student std){
        System.out.println(std.getId());
        System.out.println(std.getfName());
        System.out.println(std.getlName());
        System.out.println(std.getDesignation());
        return std;
    }

    //SpringBoot HTTP PUT Method
    @PutMapping("students/{id}/update")
    public student updateStudents(@RequestBody student std,@PathVariable("id") int studentid){
        System.out.println(std.getId());
        System.out.println(std.getfName());
        System.out.println(std.getlName());
        System.out.println(std.getDesignation());
        return  std;
    }

    //Spring Boot HTTP Delete Rest api Method
    @DeleteMapping("student/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentid){
        System.out.println(studentid);
        return "Data has been deleted succesfully....";
    }

    //http response entity example
    @GetMapping("students_entity")
    public ResponseEntity<student> getstudentsentity(){
        student std = new student(
                1,"Syed","Uzair","Developer"
        );
        //return new ResponseEntity<>(std,HttpStatus.OK);
        return ResponseEntity.ok().header(
                "custom-header","Syed").body(std);
    }

}
