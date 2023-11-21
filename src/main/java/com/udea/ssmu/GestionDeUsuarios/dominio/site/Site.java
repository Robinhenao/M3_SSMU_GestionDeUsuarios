package com.udea.ssmu.GestionDeUsuarios.dominio.site;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udea.ssmu.GestionDeUsuarios.dominio.user.User;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "sites")
@Entity
@Getter
@EqualsAndHashCode(of = "siteCode")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_code", nullable = false)
    Long siteCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_code", referencedColumnName = "user_code", nullable = false)
    @JsonIgnore
    User user;

    @Column(nullable = false, length = 100)
    String name;

    @Column(nullable = false, length = 300)
    String address;

    @Column(length = 300)
    Long icon;

    public Site(String name, String address, Long icon, User user) {
        this.name = name;
        this.address = address;
        this.icon  = icon;
        this.user = user;
    }
}
