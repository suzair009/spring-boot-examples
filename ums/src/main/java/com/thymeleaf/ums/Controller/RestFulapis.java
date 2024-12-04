package com.thymeleaf.ums.Controller;


import com.thymeleaf.ums.Entity.Department;
import com.thymeleaf.ums.Repository.DepartmentRepository;
import com.thymeleaf.ums.services.DepartmentServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/")
public class RestFulapis {

    @Autowired
    private DepartmentServices departmentServices;

    @PostMapping("/createdepartment")
    public ResponseEntity<List<Department>> createDepartment(@RequestBody List<Department> department){
        List<Department> dept = departmentServices.createDepartment(department);
        return ResponseEntity.ok(dept);
    }


}
