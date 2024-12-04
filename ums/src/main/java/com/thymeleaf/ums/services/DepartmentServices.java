package com.thymeleaf.ums.services;

import com.thymeleaf.ums.Entity.Department;

import java.util.List;

public interface DepartmentServices {
 List<Department> createDepartment(List<Department> dept);
}
