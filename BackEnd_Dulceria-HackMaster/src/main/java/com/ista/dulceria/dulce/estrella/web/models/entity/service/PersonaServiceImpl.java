package com.ista.dulceria.dulce.estrella.web.models.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ista.dulceria.dulce.estrella.web.models.entity.Persona;
import com.ista.dulceria.dulce.estrella.web.models.entity.dao.PersonaRepository;


@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository personaDAO;
	
	@Override
	public List<Persona> findAllPersona() {
		return (List<Persona>) personaDAO.findAll();
	}

	@Override
	public Persona guardarPersona(Persona persona) {
		return personaDAO.save(persona);
	}

	@Override
	public Persona findByIdPersona(Long id) {
		return personaDAO.findById(id).orElse(null);
	}

	@Override
	public void eliminarPersona(Long id) {
		this.personaDAO.deleteById(id);
	}


}
