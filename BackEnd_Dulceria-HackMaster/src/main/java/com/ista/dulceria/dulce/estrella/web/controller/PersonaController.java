package com.ista.dulceria.dulce.estrella.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ista.dulceria.dulce.estrella.web.models.entity.Persona;
import com.ista.dulceria.dulce.estrella.web.models.entity.service.PersonaService;
import com.ista.dulceria.dulce.estrella.web.models.entity.service.PersonaServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/persona")

public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/listarProcedencia")
	public List<Persona> listarPersona() {
		return personaService.findAllPersona();
	}

	@PostMapping("/guardarPersona")
	public Persona guardarPersona (@RequestBody Persona persona) {
		return this.personaService.guardarPersona(persona);
	}
	
	@DeleteMapping(value = "/eliminarPersona/{id}")
	public ResponseEntity<Boolean> eliminarActivo(@PathVariable("id") Long id) {
		personaService.eliminarPersona(id);
		return ResponseEntity.ok(!(personaService.findByIdPersona(id)!=null));
	}

	@GetMapping(value = "/buscarPPersonaPorId/{id}")
	public Persona findById(@PathVariable("id") Long id) {
		 return this.personaService.findByIdPersona(id);
	}

}
