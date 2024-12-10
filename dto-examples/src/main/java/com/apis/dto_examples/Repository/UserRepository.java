package com.apis.dto_examples.Repository;

import com.apis.dto_examples.Entity.User;
import com.apis.dto_examples.Entity.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
