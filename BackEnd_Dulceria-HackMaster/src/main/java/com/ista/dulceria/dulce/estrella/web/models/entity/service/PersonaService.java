package com.ista.dulceria.dulce.estrella.web.models.entity.service;

import java.util.List;

import com.ista.dulceria.dulce.estrella.web.models.entity.Persona;


public interface PersonaService {
	
	public List<Persona> findAllPersona();
	
	public Persona guardarPersona(Persona persona);

	public Persona findByIdPersona(Long id);
			
	public void eliminarPersona(Long id);

}
