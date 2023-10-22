package com.udea.ssmu.GestionDeUsuarios.dominio.user;

import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserData;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserRegistrationData;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.interfaces.UserService;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.validations.Validator;
import com.udea.ssmu.GestionDeUsuarios.infra.exceptions.CustomValidationException;
import com.udea.ssmu.GestionDeUsuarios.infra.exceptions.DataIntegrityValidationException;
import jakarta.validation.ValidationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private List<Validator> validators;
    private PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, List<Validator> validators, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.validators = validators;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserData registerUser(UserRegistrationData userRegistrationData) {
        List<CustomValidationException> exceptions = new ArrayList<>();
        validators.forEach(v -> {
            try {
                v.validate(userRegistrationData);
            }catch (CustomValidationException e) {
                exceptions.add(e);
            }
        });
        if (!exceptions.isEmpty()) {
            throw new DataIntegrityValidationException(exceptions);
        }

        String encodedPassword = passwordEncoder.encode(userRegistrationData.password());

        User user = new User(
                userRegistrationData.name(),
                userRegistrationData.lastName(),
                userRegistrationData.idDocument(),
                userRegistrationData.email(),
                encodedPassword);
        user = this.userRepository.save(user);
        return new UserData(user);
    }


    @Override
    public UserData getUser(Long userCode) {
       return new UserData(this.userRepository.getReferenceById(userCode));
    }

}
