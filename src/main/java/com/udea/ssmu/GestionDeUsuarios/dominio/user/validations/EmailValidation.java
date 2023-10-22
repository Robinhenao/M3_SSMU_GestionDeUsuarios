package com.udea.ssmu.GestionDeUsuarios.dominio.user.validations;

import com.udea.ssmu.GestionDeUsuarios.dominio.user.UserRepository;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserRegistrationData;
import com.udea.ssmu.GestionDeUsuarios.infra.exceptions.CustomValidationException;
import org.springframework.stereotype.Component;

@Component
public class EmailValidation implements Validator {

    private UserRepository userRepository;
    public EmailValidation(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public void validate(UserRegistrationData data) {
        if(this.userRepository.existsByEmail(data.email())){
            System.out.println(this.userRepository.existsByEmail(data.email()));
            throw new CustomValidationException("Email", "The email (" + data.email() +") is already in use.");
        }
    }
}
