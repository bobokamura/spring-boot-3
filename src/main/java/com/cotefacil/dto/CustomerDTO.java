package com.cotefacil.dto;

import com.cotefacil.model.Customer;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private Integer id;
    private String name;
    private String email;
    private Integer age;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public CustomerDTO(Customer entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        age = entity.getAge();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
