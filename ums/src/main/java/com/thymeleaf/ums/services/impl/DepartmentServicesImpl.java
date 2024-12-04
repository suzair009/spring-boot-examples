package com.thymeleaf.ums.services.impl;

import com.thymeleaf.ums.Entity.Department;
import com.thymeleaf.ums.Repository.DepartmentRepository;
import com.thymeleaf.ums.services.DepartmentServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServicesImpl implements DepartmentServices {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> createDepartment(List<Department> dept) {
        return departmentRepository.saveAll(dept);
    }
}
