package com.udea.ssmu.GestionDeUsuarios.dominio.user.dto;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateData(
        @NotBlank
        Long userCode,
        @NotBlank
        String name,
        @NotBlank
        String lastName
) {
}
