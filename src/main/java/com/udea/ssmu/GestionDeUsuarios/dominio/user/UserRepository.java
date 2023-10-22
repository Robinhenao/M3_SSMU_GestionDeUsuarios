package com.udea.ssmu.GestionDeUsuarios.dominio.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public List<User> findByUserCodeOrIdDocument(Long userCode, String idDocument);


    boolean existsByEmail(String email);

    boolean existsByIdDocument(String s);
}
