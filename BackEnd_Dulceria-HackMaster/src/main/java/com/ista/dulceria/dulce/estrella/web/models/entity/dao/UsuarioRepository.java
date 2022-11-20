package com.ista.dulceria.dulce.estrella.web.models.entity.dao;

import com.ista.dulceria.dulce.estrella.web.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);

    public Usuario findByCedula(String cedula);


    //Metodos Query
    @Query(value = "SELECT * FROM usuario WHERE cedula = ?",
            nativeQuery = true
    )
    List<Usuario> buscarUsuario(String cedula);
}
