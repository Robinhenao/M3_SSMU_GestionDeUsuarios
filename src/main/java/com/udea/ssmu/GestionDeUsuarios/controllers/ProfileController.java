package com.udea.ssmu.GestionDeUsuarios.controllers;


import com.udea.ssmu.GestionDeUsuarios.dominio.profile.dto.ProfileData;
import com.udea.ssmu.GestionDeUsuarios.dominio.profile.dto.ProfileRegistrationData;
import com.udea.ssmu.GestionDeUsuarios.dominio.profile.interfaces.ProfileService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/profile")
@CrossOrigin("*")
public class ProfileController {

    ProfileService profileService;

    public ProfileController(ProfileService profileService) {

        this.profileService = profileService;
    }

    @GetMapping("/{id_profile}")
    public ResponseEntity<ProfileData> getProfile(@PathVariable Long id_profile){
        return ResponseEntity.ok().body(this.profileService.getProfile(id_profile));
    }

    @GetMapping
    public ResponseEntity<List<ProfileData>> getProfiles(){
        return ResponseEntity.ok().body(this.profileService.getProfiles());
    }

    @PostMapping
    public ResponseEntity<ProfileData> postProfile(@RequestBody @Valid ProfileRegistrationData profileRegistrationData, UriComponentsBuilder uriComponentsBuilder){
        ProfileData profileData = this.profileService.postProfile(profileRegistrationData);
        URI uri = uriComponentsBuilder.path("/profile/{idProfile}").buildAndExpand(profileData.idProfile()).toUri();
        return ResponseEntity.created(uri).body(profileData);
    }
}
