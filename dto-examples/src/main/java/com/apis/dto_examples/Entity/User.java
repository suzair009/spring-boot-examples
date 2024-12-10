package com.apis.dto_examples.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name="User")
@Table(name="users2")
public class User {
    public User(Long id, String firstName, String lastName, String emailVal, int role) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailVal = emailVal;
        this.role = role;
    }

    public User() {
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column(name="firstName")
    public String firstName;

    @Column(name="lastName")
    public String lastName;

    @Column(name="email")
    public String emailVal;

    public int role;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailVal() {
        return emailVal;
    }

    public void setEmailVal(String emailVal) {
        this.emailVal = emailVal;
    }
}
