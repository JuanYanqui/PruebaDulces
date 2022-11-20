package com.ista.dulceria.dulce.estrella.web;

import com.ista.dulceria.dulce.estrella.web.models.entity.Rol;
import com.ista.dulceria.dulce.estrella.web.models.entity.Usuario;
import com.ista.dulceria.dulce.estrella.web.models.entity.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BackEndDulceriaApplication  {

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(BackEndDulceriaApplication.class, args);

	}

	/*@Override
	public void run(String... args) throws Exception {

			Usuario usuario = new Usuario();

			usuario.setCedula("Alex");
			usuario.setNombres("Soto");
			usuario.setUsername("alex");
			usuario.setContrasenia("12345");

			Rol rol = new Rol();
			rol.setNombre_rol("Admin");
			rol.setDescripcion("Encargado de todo");
			rol.setEstado(true);

			Set<UsuarioRol> usuariosRoles = new HashSet<>();
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setRol(rol);
			usuarioRol.setUsuario(usuario);
			usuariosRoles.add(usuarioRol);

			Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario,usuariosRoles);
			System.out.println(usuarioGuardado.getUsername());
	}*/

}
