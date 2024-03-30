package com.ppooii.trabajot1.controller;

import java.awt.print.Pageable;
import java.util.List;

import com.ppooii.trabajo1.entities.persona;
import com.ppooii.trabajot1.Services.Interfaces.PeopleServicelpm;

public class PersonaController {
	PeopleServicelpm PeopleService;
	
	//PPDG
		public boolean agregarPersona(persona persona) {
		return PeopleService.guardar(persona);
		}
		
		public boolean editarPersona(persona persona) {
		return PeopleService.actualizar(persona);
		}
			
		public boolean eliminarPersona(persona persona) {
		return PeopleService.guardar(persona);
		}
			
		public List<persona> listadoPersona(Pageable pageable){
		return PeopleService.consultarPersona(pageable);
		}
		
	//busqueda
		public persona getById(int id) {
		return PeopleService.finById(id);
		}

		public List<persona> getByNombre(String pnombre) {
		return PeopleService.findByNombre(pnombre);
		}
			
		public List<persona> getByEdad(int edad) {
		return PeopleService.findByEdad(edad);
		}
	
}
