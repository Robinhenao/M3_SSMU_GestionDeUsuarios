package com.udea.ssmu.GestionDeUsuarios.dominio.profile;


import com.udea.ssmu.GestionDeUsuarios.dominio.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Table(name = "profiles")
@Entity(name = "Profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idProfile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private Long idProfile;
    private String name;
    private String image;
    @Column(name = "main_profile")
    private Boolean mainProfile;
    @Column(name = "id_user")
    private Long idUser;
    private String pin;

    public Profile(String name, String image, Boolean mainProfile, Long idUser, String pin) {
        this.name = name;
        this.image = image;
        this.mainProfile = mainProfile;
        this.idUser = idUser;
        this.pin = pin;
    }

}
