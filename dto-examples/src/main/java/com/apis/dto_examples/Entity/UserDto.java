package com.apis.dto_examples.Entity;


public class UserDto {
    public Long Id;

    public UserDto() {
    }

    public UserDto(Long id, String firstName, String lastName, String emailVal, int role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Id = id;
        this.emailVal = emailVal;
        this.role = role;
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

    public String getEmailVal() {
        return emailVal;
    }

    public void setEmailVal(String emailVal) {
        this.emailVal = emailVal;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String firstName;
    public String lastName;
    public String emailVal;
    public int role;
}
