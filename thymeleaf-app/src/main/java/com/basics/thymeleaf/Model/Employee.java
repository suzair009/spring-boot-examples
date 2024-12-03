package com.basics.thymeleaf.Model;

public class Employee {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private String roleV;

    public Employee(Long Id,String fName,String lName,String email,String roleV){
        this.Id = Id;
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
        this.roleV = roleV;
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

    public String getRoleV() {
        return roleV;
    }

    public void setRoleV(String roleV) {
        this.roleV = roleV;
    }


}
