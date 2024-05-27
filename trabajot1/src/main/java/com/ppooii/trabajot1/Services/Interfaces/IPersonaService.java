package com.ppooii.trabajot1.Services.Interfaces;

import org.springframework.data.domain.Pageable;
import java.util.List;

import com.ppooii.trabajot1.entities.Persona;

public interface IPersonaService {
	
	//Metodos CRUD
	public boolean guardar(Persona persona);
	
	public boolean actualizar(Persona persona);
	
	public boolean eliminar(int id);
	
	public List<Persona> consultarPersona (Pageable pageble);
	
	// no se si esto no es necesario pero ahi lo dejo, igual esta a dos clicks de poder borrarlo
	//LISTA DE PERSONAS POR ID 
	public Persona findById(int Id);
	
	//LISTA DE PERSONA POR PRIMER NOMBRE
	public List<Persona> findByNombre(String PNombre);
	
	//LISTA DE PERSONA POR EDAD
	public List<Persona> findByEdad(int edad);


}
