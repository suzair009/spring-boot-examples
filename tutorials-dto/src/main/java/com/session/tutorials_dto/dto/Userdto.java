package com.session.tutorials_dto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Userdto {
    private Long Id;
    @NotEmpty(message = "FirstName should not be empty")
    private String firstName;
    @NotEmpty(message = "LastName should not be empty")
    private String lastName;
    @NotEmpty(message = "Email Should not be empty")
    @Email(message = "Email should be Valid")
    private String email;
    private String role;

    public Userdto(Long id, String firstName, String lastName, String email, String role) {
        this.Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role  = role;
    }

    public Userdto() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
