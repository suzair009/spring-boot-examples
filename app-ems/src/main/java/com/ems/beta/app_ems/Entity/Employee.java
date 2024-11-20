package com.ems.beta.app_ems.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name="department_id",unique = true)
    @JsonBackReference
    private Department department;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinTable(
            name="employee_projects",
            joinColumns = {
                    @JoinColumn(name="employee_id",referencedColumnName = "id"),
                    @JoinColumn(name="depart_id",referencedColumnName = "department_id")
            },
            inverseJoinColumns = @JoinColumn(name="project_id",referencedColumnName = "id")
    )
    private Set<Projects> projects;


    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private Set<EmployeeProject> employeeProjects;

}
