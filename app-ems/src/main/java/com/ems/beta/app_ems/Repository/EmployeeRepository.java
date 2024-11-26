package com.ems.beta.app_ems.Repository;

import com.ems.beta.app_ems.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmployeeRepository extends JpaRepository<Employees,Long> {

    @Query("Select e.firstName,e.lastName from Employees e")
    List<Object[]> findFirstNameAndLastName();

    @Query("Select e.firstName,e.lastName from Employees e Where id = :employeeid")
    List<Object[]> getFirstAndLastNameById(@Param("employeeid") Long Id);

    @Query("Select e.firstName,e.lastName,u.userId,d.department from Employees e INNER JOIN e.user u " +
            "INNER JOIN department d on d.Id = e.department.Id Where u.userId = :userId")
    List<Object[]> multipleQuerySelector(@Param("userId") String userId);

    @Query("Select e.firstName,e.lastName,u.userId," +
                "d.department,p.project,t.taskName,t.taskDetails " +
                " from Employees e INNER JOIN e.user u " +
                "INNER JOIN department d on " +
                "d.Id = e.department.Id JOIN e.projects p " +
                " JOIN p.taskProjects t "+
                "Where u.userId = :userId or d.Id=:deptId")
    List<Object[]> fetchOverallData(@Param("userId") String userId,@Param("deptId") Long DeptId);

    @Query("Select e.firstName,e.lastName,u.userId," +
            "d.department,p.project,t.taskName,t.taskDetails " +
            " from Employees e INNER JOIN e.user u " +
            "INNER JOIN department d on " +
            "d.Id = e.department.Id JOIN e.projects p " +
            " JOIN p.taskProjects t "+
            "Where u.userId = :userId or d.Id=:deptId And " +
            " e.salaryV IN (select emp.salaryV " +
            " from Employees emp Where emp.salaryV >= :averageSalary) ")
    List<Object[]> fetchAdvanceQueryData(@Param("userId") String userId,@Param("deptId") Long DeptId,
                                         @Param("averageSalary") Long averageSalary);

}
