package com.ppooii.trabajot1.Services.Interfaces;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ppooii.trabajo1.entities.persona;
import com.ppooii.trabajo1.repository.PersonaRepository;

//me acabo de enterar que algunos paquetes les puse trabajo1 y otros trabajot1, seguro por estar interrumpiendome
//espero que no haya problema

public class PeopleServicelpm {
	
	private PersonaRepository PeopleService;
	
	//log de error, no entendi esto, necesitare explicacion, lo dejo en // porque asi estaba pero ni idea
		//private static final Logger Logger = org.apache.loggin.log4j.LogManager.getLogger(PersonaServiceImpl.class);
	
	public boolean guardar(persona persona) {
		try {
			if(persona == null){
				//logger.error("ERROR AGREGAR_PERSONA: LA PERSONA ES NULO");
				return false;
			}
			else {
				PeopleService.save(persona);
				return true;
			}
		}catch(Exception e) {
			//logger.error("ERROR AGREGAR_PERSONA: LA PERSONA NO SE HA GUARDADO");
			return false;
		}
	}
	
	public boolean actualizar(persona persona) {
		try {
			if((persona == null) || (persona.getId() == 0)) {
				//logger.error("ERROR EDITAR_PERSONA: : LA PERSONA ES NULO O EL ID ES 0");
				return false;
			}
			else {
				PeopleService.save(persona);
				return true;
			}
		}catch(Exception e) {
			//logger.error("ERROR EDITAR_PERSONA: LA PERSONA NO SE HA EDITADO");
			return false;
		}
	}
	
	public boolean eliminar(int id) {
		try {
			if((id == 0)) {
				//logger.error("ERROR ELIMINAR_ PERSONA: EL ID DE LA PERSONA ES 0");
				return false;
			}
			else {
				persona persona = PeopleService.findById(id);
				PeopleService.delete(persona);
				return true;
			}
		}catch(Exception e) {
			//logger.error("ERROR EDITAR_PERSONA: LA PERSONA NO SE HA EDITADO");
			return false;
		}
		
	}
	
	public List<persona> consultarPersona (Pageable pageable){
		return (List<persona>) PeopleService.findAll(pageable);
	}
	
	public persona finById(int id) {
		return PeopleService.findById(id);
	}
	
	public List<persona> findByNombre(String pnombre) {
		return PeopleService.findByPNombre(pnombre);
	}
	
	public List<persona> findByEdad(int edad){
		return PeopleService.findByEdad(edad);
	}
	
}
