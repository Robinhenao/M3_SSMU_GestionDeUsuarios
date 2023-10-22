package com.udea.ssmu.GestionDeUsuarios.dominio.user.interfaces;

import com.udea.ssmu.GestionDeUsuarios.dominio.user.User;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserData;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserRegistrationData;

public interface UserService {

    public UserData registerUser(UserRegistrationData userRegistrationData);

    public UserData getUser(Long userCode);
}
