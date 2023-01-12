package com.cotefacil.dto;

import com.cotefacil.model.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private Integer id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 25, message = "Esse campo deve conter no mínimo 3 e no máximo 25 caracteres")
    private String name;

    @NotBlank(message = "Campo e-mail obrigatório")
    private String email;

    @NotNull(message = "Idade obrigatória")
//    @Size(min = 1, max = 3, message = "Esse campo deve conter no mínimo 1 e no máximo 3 caracteres")
    @Positive(message = "Esse campo deve ser um número positivo")
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
