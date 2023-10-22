package com.udea.ssmu.GestionDeUsuarios.dominio.user.validations;

import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserRegistrationData;
import org.springframework.stereotype.Component;


public interface Validator {

    public void validate(UserRegistrationData data);
}
