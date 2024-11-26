package com.ems.beta.app_ems.Service;

import com.ems.beta.app_ems.Entity.Employees;
import com.ems.beta.app_ems.Entity.User;

import java.util.List;

public interface EmpService {

    List<Employees> createEmployee(List<Employees> emp);

    Employees getOrderById(Long empId);

    Employees createEmployeeWithUser(Employees employee, User user);

    Employees createEmployeeWithDepartment(Employees employee, Long deptId);

    Employees createEmployeeToProject(Long EmployeeId, Long ProjectId);





}
