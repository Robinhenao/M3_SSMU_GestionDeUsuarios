package com.udea.ssmu.GestionDeUsuarios.dominio.site;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SiteRepository extends JpaRepository<Site,Long> {
}
