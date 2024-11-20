package com.ems.beta.app_ems.Service;

import com.ems.beta.app_ems.Entity.Department;
import com.ems.beta.app_ems.Entity.Employee;
import com.ems.beta.app_ems.Entity.Projects;
import com.ems.beta.app_ems.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpService {

    List<Employee> createEmployee(List<Employee> emp);

    Employee getOrderById(Long empId);

    Employee createEmployeeWithUser(Employee employee,User user);

    Employee createEmployeeWithDepartment(Employee employee,Long deptId);

    Employee createEmployeeToProject(Long EmployeeId,Long ProjectId);





}
