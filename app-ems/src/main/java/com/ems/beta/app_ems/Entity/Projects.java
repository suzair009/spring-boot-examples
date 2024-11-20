package com.ems.beta.app_ems.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="projects")

public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="project_name")
    private String project;

    @Column(name="status")
    private int status;

    @ManyToMany(mappedBy = "projects",fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Employee> employees;

    @OneToMany(mappedBy = "projects",cascade = CascadeType.ALL)
    private Set<EmployeeProject> employeeProjects;



}
