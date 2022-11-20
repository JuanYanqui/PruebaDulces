package com.ista.dulceria.dulce.estrella.web.models.entity.service;

import com.ista.dulceria.dulce.estrella.web.models.entity.Rol;
import com.ista.dulceria.dulce.estrella.web.models.entity.UserDetails;
import com.ista.dulceria.dulce.estrella.web.models.entity.Usuario;
import com.ista.dulceria.dulce.estrella.web.models.entity.UsuarioPrincipal;
import com.ista.dulceria.dulce.estrella.web.models.entity.dao.RolRepository;
import com.ista.dulceria.dulce.estrella.web.models.entity.dao.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuariosDao;
    private final RolRepository rolRepositoryDao;

    @Override
    public Rol saveRole(Rol rol) {
        log.info("Guardado nuevo rol {} en la BD", rol.getNombre_rol());
        return rolRepositoryDao.save(rol);
    }

    @Override
    public void addRoleToUser(Usuario usuario) {
        log.info("Añadido rol {} a usuario {}", usuario.getRoles(), usuario.getCedula());
        usuariosDao.save(usuario);
    }


    @Override
    public Usuario getUsuario(String cedula) {
        log.info("Fetching usuario {}", cedula);
        return usuariosDao.findByCedula(cedula);
    }

    @Override
    public List<Usuario> getUsusarios() {
        log.info("Recorrido de todos los usuarios");
        return usuariosDao.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Usuario user = usuariosDao.findByCedula(cedula);
        Usuario user = usuariosDao.findByUsername(username);
        if (user == null){
            log.error("Ususario no esta en la base de datos..");
            throw new UsernameNotFoundException("Ususario no esta en la base de datos..");
        } else {
            log.info("Usuarion en la base de datos: {}", username);
        }
        return UsuarioPrincipal.build(user);
    }

    //Metodos generados-------------------------------------------------------------------

    // EXTRA LOS DATOS DE USUARIO
    public List<Usuario> findAllByName (String cedula){
        List<Usuario> estadosRespuesta= new ArrayList<>();
        List<Usuario> user = usuariosDao.findAll();
        for (int i=0; i<user.size(); i++) {
            if (user.get(i).getCedula().toString() == cedula) {
                estadosRespuesta.add(user.get(i));
            }
        }
        return estadosRespuesta;
    }


    @Override
    public List<Usuario> findAllUsuario() {
        return (List<Usuario>) usuariosDao.findAll();
    }

    @Override
    @Transactional(readOnly= true)
    public Usuario findByIdUsuario(Long id) {
        return usuariosDao.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> buscarUsuario(String cedula) {
        return usuariosDao.buscarUsuario(cedula);
    }

    //Implementación de los nuevos metodos del grupo de josé..
    @Override
    public Usuario findById(Long id) {
        // TODO Auto-generated method stub
        return usuariosDao.findById(id).orElse(null);
    }

}
