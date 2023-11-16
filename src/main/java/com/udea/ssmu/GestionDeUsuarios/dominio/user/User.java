package com.udea.ssmu.GestionDeUsuarios.dominio.user;

import com.udea.ssmu.GestionDeUsuarios.dominio.user.dto.UserRegistrationData;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "userCode")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_code", nullable = false)
    private Long userCode;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "id_document", unique = true, nullable = false, length = 50)
    private String idDocument;

    @Column(nullable = false, unique = true, length = 300)
    private String email;

    @Column(nullable = false, length = 300)
    private String password;

    public User(String name, String lastName, String idDocument, String email, String encodedPassword) {
        this.name = name;
        this.lastName = lastName;
        this.idDocument = idDocument;
        this.email = email;
        this.password = encodedPassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
