package com.udea.ssmu.GestionDeUsuarios.dominio.user;

import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserData;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserRegistrationData;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserUpdateData;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.interfaces.UserService;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.validations.UserValidator;
import com.udea.ssmu.GestionDeUsuarios.infra.exceptions.CustomValidationException;
import com.udea.ssmu.GestionDeUsuarios.infra.exceptions.DataIntegrityValidationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private List<UserValidator> validators;
    private PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, List<UserValidator> validators, PasswordEncoder passwordEncoder){
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

    @Override
    public UserData updateUser(UserUpdateData userUpdateData) {
        User user = this.userRepository.getReferenceById(userUpdateData.userCode());
        user.setName(userUpdateData.name());
        user.setLastName(userUpdateData.lastName());
        return new UserData(user);
    }

}
