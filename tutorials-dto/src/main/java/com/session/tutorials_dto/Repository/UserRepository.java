package com.session.tutorials_dto.Repository;

import com.session.tutorials_dto.Entity.User;
import com.session.tutorials_dto.dto.Userdto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    @Query("Select e.firstName,e.lastName ,e.email,Case When e.role='0' " +
            "Then 'User' When e.role='1' Then 'Admin' " +
            "Else '-' End as roleString from User e Where e.email= :emailId")
    List<Object[]> findBycustomEmail(@Param("emailId") String emailId);
}
