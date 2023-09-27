package com.udea.ssmu.GestionDeUsuarios.dominio.site;


import com.udea.ssmu.GestionDeUsuarios.dominio.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "sites")
@Entity(name = "Site")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codeSite")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codeSite;
    String name;
    String address;
    /**
    @ManyToOne(fetch = FetchType.LAZY)
    User user;
    **/
}
