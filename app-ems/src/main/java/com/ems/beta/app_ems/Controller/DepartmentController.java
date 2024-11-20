package com.ems.beta.app_ems.Controller;

import com.ems.beta.app_ems.Entity.Department;
import com.ems.beta.app_ems.Service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("create")
    public ResponseEntity<Department> createDepartments(@RequestBody Department department){
        Department dept = departmentService.createDepartments(department);
        return new ResponseEntity<>(dept, HttpStatus.CREATED);

    }
}
