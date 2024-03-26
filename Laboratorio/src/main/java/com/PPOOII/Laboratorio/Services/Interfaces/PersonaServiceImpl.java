package com.PPOOII.Laboratorio.Services.Interfaces;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.PPOOII.Laboratorio.Entities.Persona;
import com.PPOOII.Laboratorio.Repository.PersonaRepository;

@Service("PersonaService")
public class PersonaServiceImpl {
	//INYECCION DE DEPENDENCIAS
		@Autowired
		@Qualifier("IPersonaRepo")
		private PersonaRepository IPersonaRepository;
		
	//LOS DE ERROR	
		//private static final Logger Logger = org.apache.loggin.log4j.LogManager.getLogger(PersonaServiceImpl.class);
	
	//INSERT
	//@Override
	public boolean guardar(Persona persona) {
		try {
			if(persona == null){
				//logger.error("ERROR AGREGAR_PERSONA: LA PERSONA ES NULO");
				return false;
			}
			else {
				IPersonaRepository.save(persona);
				return true;
			}
		}catch(Exception e) {
			//logger.error("ERROR AGREGAR_PERSONA: LA PERSONA NO SE HA GUARDADO");
			return false;
		}
	}
	//UPDATE
	//@Override
	public boolean actualizar(Persona persona) {
		try {
			if((persona == null) || (persona.getId() == 0)) {
				//logger.error("ERROR EDITAR_PERSONA: : LA PERSONA ES NULO O EL ID ES 0");
				return false;
			}
			else {
				IPersonaRepository.save(persona);
				return true;
			}
		}catch(Exception e) {
			//logger.error("ERROR EDITAR_PERSONA: LA PERSONA NO SE HA EDITADO");
			return false;
		}
	}
		//ELIMINAR
		//@Override
	public boolean eliminar(int id) {
		try {
			if((id == 0)) {
				//logger.error("ERROR ELIMINAR_ PERSONA: EL ID DE LA PERSONA ES 0");
				return false;
			}
			else {
				Persona persona = IPersonaRepository.findById(id);
				IPersonaRepository.delete(persona);
				return true;
			}
		}catch(Exception e) {
			//logger.error("ERROR EDITAR_PERSONA: LA PERSONA NO SE HA EDITADO");
			return false;
		}
		
	}
	
	//LISTA DE PRODUCTOS
		public List<Persona> consultarPersona (Pageable pageable){
			return (List<Persona>) IPersonaRepository.findAll(pageable);
		}
		
	//METODOS DE BUSQUEDA
		
		//PERSONA POR ID | VALOR UNICO
		//@Override
		public Persona finById(int id) {
			return IPersonaRepository.findById(id);
		}

		//LIST DE PERSONAS POR NOMBRE
		//@Override
		public List<Persona> findByNombre(String pnombre) {
			return IPersonaRepository.findByPNombre(pnombre);
		}
		
		//LISTADO DE PERSONAS POR EDAD
		//@Override
		public List<Persona> findByEdad(int edad){
			return IPersonaRepository.findByEdad(edad);
		}
}
