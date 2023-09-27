package com.udea.ssmu.GestionDeUsuarios.dominio.user;

public record UserData(
        Long codeUser,
        String name,
        String lastName,
        String identityCard,
        String email
) {

    public UserData(User user){
        this(user.getCodeUser(), user.getName(), user.getLastName(), user.getIdentityCard(), user.getEmail());
    }
}
