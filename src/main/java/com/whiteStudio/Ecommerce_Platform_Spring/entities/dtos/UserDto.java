package com.whiteStudio.Ecommerce_Platform_Spring.entities.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDto(

        @NotNull(message = "O nome não pode ser nulo")
        @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 chars")
        String name,


        @NotNull(message = "O nome não pode ser nulo")
        @Email(message = "E-mail inválido")
        String email,

        @NotNull(message = "O nome não pode ser nulo")
        @Size(min = 10, max = 15, message = "O telefone deve ter entre 10 e 15 chars")
        String phone,

        @NotNull(message = "O nome não pode ser nulo")
        @Size(min = 8, message = "A senha deve possuir no minimo 8 chars")
        String password
)
{}
