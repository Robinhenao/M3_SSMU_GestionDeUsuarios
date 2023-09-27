package com.udea.ssmu.GestionDeUsuarios.dominio.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public List<User> findByCodeUserOrIdentityCard(Long codeUser, String identityCard);
}
