package com.ems.beta.app_ems.Controller;


import com.ems.beta.app_ems.Entity.Projects;
import com.ems.beta.app_ems.Service.ProjectsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/projects")
public class ProjectsController {

    @Autowired
    private ProjectsService projectsService ;

    @PostMapping("/create")
    public ResponseEntity<List<Projects>> createProjects(@RequestBody List<Projects> projects){
       List<Projects> projects1 = projectsService.createProjects(projects);
        return new ResponseEntity<>(projects, HttpStatus.CREATED);
    }

}
