package com.udea.ssmu.GestionDeUsuarios.dominio.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {



}
