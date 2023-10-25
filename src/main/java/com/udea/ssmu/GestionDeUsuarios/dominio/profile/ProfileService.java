package com.udea.ssmu.GestionDeUsuarios.dominio.profile;


import com.udea.ssmu.GestionDeUsuarios.dominio.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;
    private UserRepository userRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileData getProfile(Long idProfile) {
        return new ProfileData(this.profileRepository.getReferenceById(idProfile));
    }

    public List<ProfileData> getProfiles() {
        return  profileRepository.findAll().stream().map(ProfileData::new).collect(Collectors.toList());
    }


    public ProfileData postProfile(ProfileRegistrationData profileRegistrationData) {
        Profile profile = new Profile(
                profileRegistrationData.name(),
                profileRegistrationData.image(),
                profileRegistrationData.mainProfile(),
                profileRegistrationData.idUser(),
                profileRegistrationData.pin()
                );
        profile = this.profileRepository.save(profile);
        return new ProfileData(profile);
    }
}
