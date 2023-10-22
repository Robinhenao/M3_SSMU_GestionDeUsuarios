package com.udea.ssmu.GestionDeUsuarios.dominio.user;

import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserRegistrationData;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "userCode")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_code")
    private Long userCode;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "id_document")
    private String idDocument;
    private String email;
    private String password;

    public User(String name, String lastName, String idDocument, String email, String encodedPassword) {
        this.name = name;
        this.lastName = lastName;
        this.idDocument = idDocument;
        this.email = email;
        this.password = encodedPassword;
    }
}
