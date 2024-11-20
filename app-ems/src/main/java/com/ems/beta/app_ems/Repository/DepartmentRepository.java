package com.ems.beta.app_ems.Repository;

import com.ems.beta.app_ems.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
