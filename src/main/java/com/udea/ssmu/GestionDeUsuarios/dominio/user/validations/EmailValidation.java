package com.udea.ssmu.GestionDeUsuarios.dominio.user.validations;

import com.udea.ssmu.GestionDeUsuarios.dominio.user.UserRepository;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserRegistrationData;
import com.udea.ssmu.GestionDeUsuarios.infra.exceptions.CustomValidationException;
import org.springframework.stereotype.Component;

@Component
public class EmailValidation implements UserValidator {

    private UserRepository userRepository;
    public EmailValidation(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public void validate(UserRegistrationData data) {
        if (this.userRepository.existsByIdDocument(data.idDocument())){
            throw new CustomValidationException("idDocument","The ID document (" + data.idDocument() +") is already in use.");
        }
    }
}
