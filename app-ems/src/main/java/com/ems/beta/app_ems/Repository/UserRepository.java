package com.ems.beta.app_ems.Repository;

import com.ems.beta.app_ems.Entity.Employee;
import com.ems.beta.app_ems.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

}
