package com.udea.ssmu.GestionDeUsuarios.dominio.site.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SiteRegistrationData(
        @NotNull
        Long userCode,
        @NotBlank
        String name,
        @NotBlank
        String address,
        @NotBlank
        String icon
) {
}
