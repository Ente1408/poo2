package com.PPOOII.Laboratorio.Controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PPOOII.Laboratorio.Entities.Persona;
import com.PPOOII.Laboratorio.Services.Interfaces.PersonaServiceImpl;

	@RestController
	@RequestMapping("/LaboratorioV1")

public class PersonaController {
	//INYECCION DEL SERVICES
	@Autowired
	@Qualifier("PersonaService")
	PersonaServiceImpl personaService;
	
//METODOS HTTP
		//METODO POST
		@PostMapping("/persona")
		public boolean agregarPersona(@RequestBody @Validated Persona persona) {
			return personaService.guardar(persona);
		}
		
		//METODO PUT
		@PutMapping("/persona")
		public boolean editarPersona(@RequestBody @Validated Persona persona) {
			return personaService.actualizar(persona);
		}
		
		//METODO DELETE
		@DeleteMapping("/persona")
		public boolean eliminarPersona(@RequestBody @Validated Persona persona) {
			return personaService.guardar(persona);
		}
		
		//METODO GET
		@GetMapping("/persona")
		public List<Persona> listadoPersona(Pageable pageable){
			return personaService.consultarPersona(pageable);
		}
//METODO HTTP DE BUSQUEDA
		//METODO GET
		@GetMapping("/persona/id/{id}")
		public Persona getById(@PathVariable("id") int id) {
			return personaService.finById(id);
		}

		//METODO GET
		@GetMapping("/persona/pnombre/{pnombre}")
		public List<Persona> getByNombre(@PathVariable("pnombre") String pnombre) {
			return personaService.findByNombre(pnombre);
		}
		
		//METODO GET
		@GetMapping("/persona/edad/{edad}")
		public List<Persona> getByEdad(@PathVariable("edad") int edad) {
			return personaService.findByEdad(edad);
		}
		
}
