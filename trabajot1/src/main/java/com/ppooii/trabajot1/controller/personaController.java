package com.ppooii.trabajot1.controller;

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

import com.ppooii.trabajo1.entities.persona;
import com.ppooii.trabajot1.Services.Interfaces.PeopleServicelpm;


@RestController
@RequestMapping("/api")
public class personaController {
	
	//======INYECCION DEL SERVICE==========
	@Autowired
	PeopleServicelpm PeopleService; 
	
	//======== METODOS HTTP==========
	
	//METODO POST
	@PostMapping("/persona")
	public boolean agregarPersona(@RequestBody @Validated persona per){
		return PeopleService.guardar(per);
	}
	
	//METODO PUT
	@PutMapping("/persona")
	public boolean editarPersona(@RequestBody @Validated persona per){
		return PeopleService.actualizar(per);
	}
	
	//METODO DELETE
	@DeleteMapping("/persona/{id}")
	public boolean eliminarPersona(@PathVariable("id") int id){
		return PeopleService.eliminar(id);
	}

	//METODO GET
	@GetMapping("/persona")
	public List<persona> listadoPersona(Pageable pageable){
		return PeopleService.consultarPersona(pageable);
	}
	
	//=========METODOS HTTP DE BUSQUEDA ==========
	
	//----GET-----	
	@GetMapping("/persona/id/{id}")
	public persona getbyId(@PathVariable("id") int id) {
		return PeopleService.finById(id);
	}
	
	//----GET-----	
	@GetMapping("/persona/pnombre/{pnombre}")
	public List<persona> getByNombre(@PathVariable("pnombre") String pnombre){
		return PeopleService.findByNombre(pnombre);
	}
		
	//----GET-----	
	@GetMapping("/persona/edad/{edad}")
	public List<persona> getByEdad(@PathVariable("edad") int Edad){
		return PeopleService.findByEdad(Edad);
	}
	
}
