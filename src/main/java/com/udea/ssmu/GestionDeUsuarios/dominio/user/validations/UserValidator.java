package com.udea.ssmu.GestionDeUsuarios.dominio.user.validations;

import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserRegistrationData;
import org.springframework.stereotype.Component;


public interface UserValidator {

    public void validate(UserRegistrationData data);
}
