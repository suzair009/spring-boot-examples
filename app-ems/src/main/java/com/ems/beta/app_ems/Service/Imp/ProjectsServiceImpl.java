package com.ems.beta.app_ems.Service.Imp;

import com.ems.beta.app_ems.Entity.Projects;
import com.ems.beta.app_ems.Repository.ProjectsRepository;
import com.ems.beta.app_ems.Service.ProjectsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectsServiceImpl implements ProjectsService {

    @Autowired
    private ProjectsRepository projectsRepository;

    @Override
    public List<Projects> createProjects(List<Projects> projects) {
        return projectsRepository.saveAll(projects);
    }
}
