package com.backend.ecommerce.repository;

import com.backend.ecommerce.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<Users,Long> {
}
