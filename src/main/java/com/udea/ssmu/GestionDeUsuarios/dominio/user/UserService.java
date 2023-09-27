package com.udea.ssmu.GestionDeUsuarios.dominio.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public  UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    
    /**
     * Retrieves user data based on the provided user code.
     *
     * @param codeUser The unique code of the user to retrieve.
     * @return An Optional containing user data if a user with the specified code is found,
     *         or an empty Optional if the user does not exist.
     */
    public Optional<UserData> getUserData(Long codeUser) {
        return this.userRepository.findById(codeUser).map(UserData::new);
    }


    /**
     * Updates user data based on the provided user data update request.
     *
     * @param userDataUpdate The request containing the updated user data.
     * @return A ResponseEntity containing the result of the user data update operation.
     *         - If the update is successful, it returns an HTTP 200 OK status with a success message.
     *         - If the user is not found, it returns an HTTP 400 Bad Request status with an error message.
     *         - If the identity card number is already used by another user, it returns an HTTP 400 Bad Request status with an error message.
     */
    public ResponseEntity<Object> updateUser(UserDataUpdate userDataUpdate) {
        List<User> users = userRepository.findByCodeUserOrIdentityCard(userDataUpdate.codeUser(), userDataUpdate.identityCard());
        if(users.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        } else if(users.size()==1 && Objects.equals(users.get(0).getCodeUser(), userDataUpdate.codeUser())) {
            User user = users.get(0);
            if(userDataUpdate.name() != null) {
                user.setName(userDataUpdate.name());
            }
            if(userDataUpdate.lastName() != null) {
                user.setLastName(userDataUpdate.lastName());
            }
            if(userDataUpdate.identityCard() != null) {
                user.setIdentityCard(userDataUpdate.identityCard());
            }
            return ResponseEntity.ok("the user was updated");
        } else {
            return ResponseEntity.badRequest().body("The identity card number is already being used by another user.");
        }
    }
}
