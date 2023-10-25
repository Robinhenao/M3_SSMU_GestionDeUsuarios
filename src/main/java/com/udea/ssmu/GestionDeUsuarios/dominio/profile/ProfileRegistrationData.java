package com.udea.ssmu.GestionDeUsuarios.dominio.profile;

import com.udea.ssmu.GestionDeUsuarios.dominio.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ProfileRegistrationData(

        @NotBlank
        String name,

        String image,

        @NotNull
        Boolean mainProfile,

        @NotNull
        Long idUser,

        @NotBlank
        @Size(min = 4, max = 4)
        @Pattern(regexp = "\\d{4}")
        String pin

) {
}
