package com.udea.ssmu.GestionDeUsuarios.dominio.user.dto;

import com.udea.ssmu.GestionDeUsuarios.dominio.user.User;

public record UserData(
        Long userCode,
        String name,
        String lastName,
        String idDocument,
        String email

) {
    public UserData(User user) {
        this(user.getUserCode(), user.getName(), user.getLastName(), user.getIdDocument(), user.getEmail());
    }
}
