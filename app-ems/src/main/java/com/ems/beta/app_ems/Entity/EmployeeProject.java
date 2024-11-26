package com.ems.beta.app_ems.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee_projects")
public class EmployeeProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employees employee;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Projects projects;

    @Column(name="role")
    private int role;

    @Column(name="status")
    private int status;


}
