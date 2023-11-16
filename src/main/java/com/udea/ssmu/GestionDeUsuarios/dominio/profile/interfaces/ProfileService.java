package com.udea.ssmu.GestionDeUsuarios.dominio.profile.interfaces;

import com.udea.ssmu.GestionDeUsuarios.dominio.profile.dto.ProfileData;
import com.udea.ssmu.GestionDeUsuarios.dominio.profile.dto.ProfileRegistrationData;

import java.util.List;

public interface ProfileService {
    ProfileData getProfile(Long idProfile);

    List<ProfileData> getProfiles();

    ProfileData postProfile(ProfileRegistrationData profileRegistrationData);
}
