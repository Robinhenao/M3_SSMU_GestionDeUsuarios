package com.udea.ssmu.GestionDeUsuarios.controller;


import com.udea.ssmu.GestionDeUsuarios.dominio.user.UserData;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.UserDataUpdate;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * Retrieves user data based on the user's unique code.
     *
     * @param codeUser The unique code of the user to retrieve.
     * @return An Optional object containing the user's data if found,
     *         or an empty Optional if the user does not exist.
     */
    @GetMapping("/{codeUser}")
    public Optional<UserData> getUserData(@PathVariable Long codeUser){
        return this.userService.getUserData(codeUser);
    }


    /**
     * Updates user data based on the provided user data update request.
     *
     * @param userDataUpdate The request body containing the updated user data.
     * @return A ResponseEntity containing the result of the user data update operation.
     *         - If the update is successful, it returns an HTTP 200 OK status.
     *         - If the update fails due to validation errors or other issues, it returns an appropriate error status.
     */
    @PutMapping
    @Transactional
    public ResponseEntity<Object> updateUser(@RequestBody @Valid UserDataUpdate userDataUpdate){
        return this.userService.updateUser(userDataUpdate);
    }

}
