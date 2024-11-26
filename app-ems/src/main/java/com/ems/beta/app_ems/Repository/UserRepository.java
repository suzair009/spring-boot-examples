package com.ems.beta.app_ems.Repository;


import com.ems.beta.app_ems.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("Select u.userName,u.userId from User u")
    List<Object[]> getUsersDatabyQuery();

    @Query("Select u.userName,e.firstName from User u LEFT JOIN u.employee e " +
            "Where u.userName = :userName")
    List<Object[]> getUsersDatabyQueryName(@Param("userName") String username);
}
