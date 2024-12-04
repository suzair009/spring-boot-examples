package com.thymeleaf.ums.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {
    public int Id;
    public String name;

    public Role(int Id, String name){
        this.Id = Id;
        this.name = name;
    }
}
