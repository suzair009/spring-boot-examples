package net.java.example.springboot_rest_api.bean;

public class employee {
    private String firstname;
    private String lastname;
    private int id;

    public employee(int id, String firstname, String lastname){
        this.id = id;
        this.firstname  = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}
