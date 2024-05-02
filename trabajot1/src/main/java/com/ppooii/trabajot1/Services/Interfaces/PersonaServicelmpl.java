package com.ppooii.trabajot1.Services.Interfaces;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ppooii.trabajot1.entities.Persona;
import com.ppooii.trabajot1.entities.Usuario;
import com.ppooii.trabajot1.repository.PersonaRepository;
import com.ppooii.trabajot1.repository.UsuarioRepository;

@Service("PersonaService")
public class PersonaServicelmpl implements IPersonaService{

	@Autowired
	@Qualifier("IPersonaRepo")
	private PersonaRepository IPersonaRepository;
	
	@Autowired
	@Qualifier("IUsuarioRepo")
	private UsuarioRepository IUsuarioRepository;
	
	//Log de Errores
	private static Logger logger = LoggerFactory.getLogger(PersonaServicelmpl.class);
	
	//INSERT
	@Override
	public boolean guardar(Persona persona) {
		try {
			if(persona == null) {
				logger.error("ERROR AGREGAR PERSONA: LA PERSONA ES NULO");
				return false;
			}else {
				IPersonaRepository.save(persona);
				Usuario user = new Usuario(
						persona.getPrimerNombre()+persona.getPrimerApellido().charAt(0)+persona.getId(),"12345","12345",persona
						);
				IUsuarioRepository.save(user);
				logger.info("AGREGAR PERSONA: PERSONA AGREGADA!");
				return true;
			}
			
		}catch(Exception e){
			
			logger.error("ERROR AGREGAR PERSONA: LA PERSONA NO SE HA GUARDADO");
			return false;
		}
	}

	//UPDATE
	@Override
	public boolean actualizar(Persona persona) {
		try {
			if((persona == null)||(persona.getId() == 0)) {
				logger.error("ERROR EDITAR PERSONA: LA PERSONA ES O ID ES 0");
				return false;
			}else {
				IPersonaRepository.save(persona);
				logger.info("EDITAR PERSONA: PERSONA EDITADA!");
				return true;
			}
			
		}catch(Exception e){
			logger.error("ERROR ACTUALIZAR PERSONA: LA PERSONA NO SE HA EDITADO!!");
			return false;
		}
	}

	@Override
	public boolean eliminar(int id) {
		try {
			if((id == 0)) {
				logger.error("ERROR ELIMINAR PERSONA: LA PERSONA ES O ID ES 0");
				return false;
			}else {
				Persona persona = IPersonaRepository.findAllById(id);
				IPersonaRepository.delete(persona);
				logger.info("ELIMINAR PERSONA: PERSONA ELIMINADA!");
				return true;
			}
			
		}catch(Exception e){
			logger.error("ERROR ELIMINAR PERSONA: NO SE ELIMINO LA PERSONA CORRECTAMENTE!!");
			return false;
		}
	}

	//LISTA DE PRODUCTOS
	@Override
	public List<Persona> consultarPersona(Pageable pageable) {
		return IPersonaRepository.findAll(pageable).getContent();
	}
	
	//METODOS DE BUSQUEDA

	@Override
	public Persona findById(int id) {
		return IPersonaRepository.findAllById(id);
	}

	@Override
	public List<Persona> findByNombre(String pnombre) {
		return IPersonaRepository.findAllByPNombre(pnombre);
	}

	@Override
	public List<Persona> findByEdad(int edad) {
		return IPersonaRepository.findByEdad(edad);
	}



}
