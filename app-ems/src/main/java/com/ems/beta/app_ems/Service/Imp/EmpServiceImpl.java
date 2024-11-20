package com.ems.beta.app_ems.Service.Imp;

import com.ems.beta.app_ems.Entity.Department;
import com.ems.beta.app_ems.Entity.Employee;
import com.ems.beta.app_ems.Entity.Projects;
import com.ems.beta.app_ems.Entity.User;
import com.ems.beta.app_ems.Repository.DepartmentRepository;
import com.ems.beta.app_ems.Repository.EmployeeRepository;
import com.ems.beta.app_ems.Repository.ProjectsRepository;
import com.ems.beta.app_ems.Repository.UserRepository;
import com.ems.beta.app_ems.Service.EmpService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProjectsRepository projectsRepository;


    @Override
    public List<Employee> createEmployee(List<Employee> emp) {
        return employeeRepository.saveAll(emp);
    }

    @Override
    public Employee getOrderById(Long empId) {
        return employeeRepository.findById(empId).get();
    }

    @Override
    @Transactional
    public Employee createEmployeeWithUser(Employee employee, User user) {

        //create a bidirectional link
        //parent to child (entity)
        employee.setUser(user);

        //child to parent (entity)
        user.setEmployee(employee);

        userRepository.save(user);
        return employeeRepository.save(employee);

    }

    @Override
    public Employee createEmployeeWithDepartment(Employee employee,Long deptId) {
       Department dpt  = departmentRepository.findById(deptId).get();
       employee.setFirstName(employee.getFirstName());
       employee.setLastName(employee.getLastName());
       employee.setEmail(employee.getEmail());
       employee.setDepartment(dpt);
       return employeeRepository.save(employee);
    }

    @Override
    public Employee createEmployeeToProject(Long EmployeeId, Long ProjectId) {
        Employee employee = employeeRepository.findById(EmployeeId)
                .orElseThrow(()-> new RuntimeException("Employee not found"));

        Projects projects = projectsRepository.findById(ProjectId)
                .orElseThrow(()->new RuntimeException("Project Id not found"));

        employee.getProjects().add(projects);

        projects.getEmployees().add(employee);

        return employeeRepository.save(employee);

    }



}
