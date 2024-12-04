package com.thymeleaf.ums.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Entity(name="user")
@EntityListeners(AuditingEntityListener.class)
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="username")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="gender")
    private String gender;

    @Column(name="profession")
    private int profession;

    public Integer getIsadmin() {
        return isadmin;
    }

    @Column(name="createdDate")
    @CreatedDate
    private LocalDateTime createdDate;

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }

    @Column(name="isAdmin")
    private Integer isadmin;

    @ManyToOne
    @JoinColumn(name="depart_id",nullable = false)
    private Department department;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getProfession() {
        return profession;
    }

    public void setProfession(int profession) {
        this.profession = profession;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
