package com.udea.ssmu.GestionDeUsuarios.dominio.user.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRegistrationData(
        @NotBlank
        String name,
        @NotBlank
        String lastName,
        @NotBlank
        @Pattern(regexp = "\\d{4,12}")
        String idDocument,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 6, max = 6)
        @Pattern(regexp = "^[a-zA-Z0-9]{3}[a-zA-Z0-9]{3}$")
        String password
) {
}
