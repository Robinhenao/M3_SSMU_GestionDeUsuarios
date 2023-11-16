package com.udea.ssmu.GestionDeUsuarios.dominio.site.interfaces;

import com.udea.ssmu.GestionDeUsuarios.dominio.site.dto.SiteRegistrationData;
import com.udea.ssmu.GestionDeUsuarios.dominio.site.validations.SiteValidator;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.UserRepository;
import com.udea.ssmu.GestionDeUsuarios.infra.exceptions.CustomValidationException;
import org.springframework.stereotype.Component;

@Component
public class UserExistenceValidation implements SiteValidator {
    private UserRepository userRepository;

    public UserExistenceValidation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void validate(SiteRegistrationData data) {
        if(!this.userRepository.existsById(data.userCode())){
            throw new CustomValidationException("userCode","The user code (" + data.userCode() +") does not correspond to that of a registered user.");
        }
    }
}
