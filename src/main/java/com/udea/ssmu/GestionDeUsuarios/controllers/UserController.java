package com.udea.ssmu.GestionDeUsuarios.controllers;


import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserData;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserRegistrationData;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserUpdateData;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.interfaces.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserData>  registerUser(@RequestBody @Valid UserRegistrationData userRegistrationData, UriComponentsBuilder uriComponentsBuilder){
        UserData userData = this.userService.registerUser(userRegistrationData);
        URI uri = uriComponentsBuilder.path("/users/{codeUser}").buildAndExpand(userData.userCode()).toUri();
        return ResponseEntity.created(uri).body(userData);
    }

    @GetMapping("/{userCode}")
    public ResponseEntity<UserData> getUser(@PathVariable Long userCode){
        return ResponseEntity.ok().body(this.userService.getUser(userCode));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UserData> updateUser(@RequestBody UserUpdateData userUpdateData){
        return ResponseEntity.ok(this.userService.updateUser(userUpdateData));
    }


}
