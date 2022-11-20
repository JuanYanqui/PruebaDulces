package com.ista.dulceria.dulce.estrella.web.models.entity.service;

import com.ista.dulceria.dulce.estrella.web.models.entity.Rol;
import com.ista.dulceria.dulce.estrella.web.models.entity.UserDetails;
import com.ista.dulceria.dulce.estrella.web.models.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Set;

public interface UsuarioService extends UserDetailsService {

    Rol saveRole(Rol rol);

    void addRoleToUser(Usuario usuario);

    Usuario getUsuario(String cedula);

    List<Usuario> getUsusarios();


    public List<Usuario> findAllUsuario();

    List<Usuario> buscarUsuario(String cedula);

    public Usuario findById(Long id);

    public Usuario findByIdUsuario(Long id);
    
    

}
