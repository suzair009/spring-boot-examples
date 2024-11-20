package com.ems.beta.app_ems.Repository;

import com.ems.beta.app_ems.Entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Projects,Long> {
}
