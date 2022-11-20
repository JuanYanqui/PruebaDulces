package com.ista.dulceria.dulce.estrella.web.models.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	private String cedula;
	private String nombres;
	private String username;
	private String contrasenia;
	private Boolean estado;

	public Usuario() {
	}
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_roles",
			joinColumns = @JoinColumn(name = "id_usuario"),
			inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private Set<Rol> roles = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	private Persona persona;

	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;

	public Usuario(String cedula, String nombres, String username, String contrasenia, Boolean estado) {
		this.cedula = cedula;
		this.nombres = nombres;
		this.username = username;
		this.contrasenia = contrasenia;
		this.estado = estado;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
