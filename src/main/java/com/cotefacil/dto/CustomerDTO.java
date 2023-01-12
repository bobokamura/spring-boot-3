package com.cotefacil.dto;

import com.cotefacil.model.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO implements Serializable {

    private Integer id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 25, message = "Esse campo deve conter no mínimo 3 e no máximo 25 caracteres")
    private String name;

    @NotBlank(message = "Campo e-mail obrigatório")
    private String email;

    @NotNull(message = "Idade obrigatória")
    @Positive(message = "Esse campo deve ser um número positivo")
    private Integer age;

    public CustomerDTO(Customer entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        age = entity.getAge();
    }
}
