package com.udea.ssmu.GestionDeUsuarios.dominio.profile;

import java.util.List;

public record ProfileData(
        Long idProfile,
        String name,
        String image,
        Boolean mainProfile
) {

    public ProfileData(Profile profile){
        this(profile.getIdProfile(),profile.getName(),profile.getImage(),profile.getMainProfile());
    }

    
}
