package com.udea.ssmu.GestionDeUsuarios.dominio.user;

import com.udea.ssmu.GestionDeUsuarios.dominio.site.Site;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codeUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeUser;
    private String name;
    private String lastname;
    private String cc;
    private String email;
    private List<Site> sites;





}
