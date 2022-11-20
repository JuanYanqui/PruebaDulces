package com.ista.dulceria.dulce.estrella.web.models.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_empresa;
	
	private String nombre;
	private String ruc;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "empresa")
	private Set<Usuario> usuario = new HashSet<>();

	

	public Empresa() {
		super();
	}


	public Empresa(String nombre, String ruc) {
		super();
		this.nombre = nombre;
	}


	public Long getId_empresa() {
		return id_empresa;
	}


	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRuc() {
		return ruc;
	}


	public void setRuc(String ruc) {
		this.ruc = ruc;
	}




	

}
