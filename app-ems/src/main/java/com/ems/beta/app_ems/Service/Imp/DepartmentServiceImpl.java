package com.ems.beta.app_ems.Service.Imp;

import com.ems.beta.app_ems.Entity.Department;
import com.ems.beta.app_ems.Repository.DepartmentRepository;
import com.ems.beta.app_ems.Service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartments(Department department) {
        return departmentRepository.save(department);
    }
}
