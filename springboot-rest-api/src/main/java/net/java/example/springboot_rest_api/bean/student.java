package net.java.example.springboot_rest_api.bean;

public class student {
    private String fName;
    private String lName;
    private String designation;
    private int id;

    public student(int id,String firstName,String lastName,String designation){
        this.id = id;
        this.fName = firstName;
        this.lName = lastName;
        this.designation = designation;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
