package com.udea.ssmu.GestionDeUsuarios.dominio.site;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SiteRepository extends JpaRepository<Site,Long> {

    List<Site> findAllByUser_UserCode(Long userCode);
}
