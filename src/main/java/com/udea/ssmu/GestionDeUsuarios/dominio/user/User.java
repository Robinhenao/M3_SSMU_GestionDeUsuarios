package com.udea.ssmu.GestionDeUsuarios.dominio.user;

import com.udea.ssmu.GestionDeUsuarios.dominio.site.Site;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "users")
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codeUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_user")
    private Long codeUser;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "identity_card")
    private String identityCard;
    private String email;

    /**
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Site> sites;
    **/
}
