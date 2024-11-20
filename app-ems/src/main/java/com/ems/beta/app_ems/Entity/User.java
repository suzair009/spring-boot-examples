package com.ems.beta.app_ems.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="user_name")
        private String userName;

    @Column(name="user_id")
    private String userId;


    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name="employeeId",unique = true, referencedColumnName = "id")
    @JsonBackReference
    private Employee employee;








}
