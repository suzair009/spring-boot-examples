package com.ems.beta.app_ems.Service.Imp;

import com.ems.beta.app_ems.Entity.Department;
import com.ems.beta.app_ems.Entity.Employees;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Getter
@Setter
@AllArgsConstructor
public class EmpServiceImpl implements EmpService {

   private final EmployeeRepository employeeRepository;

   @Autowired
   public EmpServiceImpl(EmployeeRepository employeeRepository) {
       this.employeeRepository = employeeRepository;
   }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProjectsRepository projectsRepository;


    @Override
    public List<Employees> createEmployee(List<Employees> emp) {
        return employeeRepository.saveAll(emp);
    }

    @Override
    public Employees getOrderById(Long empId) {
        return employeeRepository.findById(empId).get();
    }

    @Override
    @Transactional
    public Employees createEmployeeWithUser(Employees employee, User user) {

        //create a bidirectional link
        //parent to child (entity)
        employee.setUser(user);

        //child to parent (entity)
        user.setEmployee(employee);

        userRepository.save(user);
        return employeeRepository.save(employee);

    }

    @Override
    public Employees createEmployeeWithDepartment(Employees employee, Long deptId) {
       Department dpt  = departmentRepository.findById(deptId).get();
       employee.setFirstName(employee.getFirstName());
       employee.setLastName(employee.getLastName());
       employee.setEmail(employee.getEmail());
       employee.setDepartment(dpt);
       return employeeRepository.save(employee);
    }

    @Override
    public Employees createEmployeeToProject(Long EmployeeId, Long ProjectId) {
        Employees employee = employeeRepository.findById(EmployeeId)
                .orElseThrow(()-> new RuntimeException("Employee not found"));

        Projects projects = projectsRepository.findById(ProjectId)
                .orElseThrow(()->new RuntimeException("Project Id not found"));

        employee.getProjects().add(projects);

        projects.getEmployees().add(employee);

        return employeeRepository.save(employee);

    }

    public List<String> findFirstNameAndLastName(){
        List<Object[]> results = employeeRepository.findFirstNameAndLastName();
        List<String> formattedResults = new ArrayList<>();
        for (Object[] row : results) {
            String firstName = (String) row[0];
            String lastName = (String) row[1];
            formattedResults.add("First Name: " + firstName + ", lastName: " + lastName);
        }
        return formattedResults;
    }

    public List<String> getFirstAndLastNameById(Long Id){
       List<Object[]> results = employeeRepository.getFirstAndLastNameById(Id);
        List<String> formattedResults = new ArrayList<>();
        for(Object[] row:results){
            String firstName = (String) row[0];
            String lastName = (String) row[1];
            formattedResults.add("firstName:"+firstName+", LastName: "+lastName);
        }
        return formattedResults;
    }

    public List<Map<String,Object>> getQuerySelector(String useridV){

        List<Object[]> userids = employeeRepository.multipleQuerySelector(useridV);

        //convert data to a redable list of maps
        List<Map<String,Object>> response = userids.stream().map(records->{
            Map<String,Object> _value = new HashMap<>();
            _value.put("firstName",records[0]);
            _value.put("lastName",records[1]);
            _value.put("userId",records[2]);
            _value.put("department",records[3]);
            return _value;
        }).toList();

        return response;
    }

    public List<Map<String,Object>> fetchOverallData(String username,Long Id){
        List<Object[]> results = employeeRepository.fetchOverallData(username,Id);

        //convert data to a redable list of maps
        List<Map<String,Object>> _response = results.stream().map(record->{
            Map<String,Object> _value = new HashMap<>();
            _value.put("firstName",record[0]);
            _value.put("lastName",record[1]);
            _value.put("userId",record[2]);
            _value.put("department",record[3]);
            _value.put("project",record[4]);
            _value.put("taskName",record[5]);
            _value.put("taskDetails",record[6]);
            return _value;
        }).toList();

        return _response;
    }

    public List<Map<String,Object>> getSubQueryData(String username,Long Id,Long salaryAmount){
        List<Object[]> results = employeeRepository.fetchAdvanceQueryData(username,Id,salaryAmount);
        List<Map<String,Object>> mapValues = results.stream().map(record->{
            Map<String,Object> _value = new HashMap<>();
            _value.put("firstName",record[0]);
            _value.put("lastName",record[1]);
            _value.put("userId",record[2]);
            _value.put("department",record[3]);
            _value.put("project",record[4]);
            _value.put("taskName",record[5]);
            _value.put("taskDetails",record[6]);
            return _value;
        }).toList();

        return mapValues;
    }

}
