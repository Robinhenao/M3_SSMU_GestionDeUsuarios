package com.udea.ssmu.GestionDeUsuarios.dominio.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserDataUpdate(
        @NotNull Long codeUser,
        String name,
        String lastName,
        @Pattern(regexp = "\\d{4,10}")
        String identityCard
) {
}
