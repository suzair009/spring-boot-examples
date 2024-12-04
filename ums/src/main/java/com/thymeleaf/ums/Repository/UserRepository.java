package com.thymeleaf.ums.Repository;

import com.thymeleaf.ums.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u,d FROM user u JOIN department " +
            " d on d.Id = u.department.Id")
     List<User> showUsersData();
}
