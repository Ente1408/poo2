package com.ppooii.trabajot1.Services.Interfaces;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppooii.trabajo1.entities.persona;

@Service
public interface IPeopleService {
	
	 @Autowired
	//Metodos CRUD
	public boolean guardar(persona persona);
	
	public boolean actualizar(persona persona);
	
	public boolean eliminar(int id);
	
	public List<persona> consultarPersona (Pageable pageble);
	
	// no se si esto no es necesario pero ahi lo dejo, igual esta a dos clicks de poder borrarlo
	//LISTA DE PERSONAS POR ID 
		public persona finById(int id);
		
		//LISTA DE PERSONA POR PRIMER NOMBRE
		public List<persona> findByNombre(String pnombre);
		
		//LISTA DE PERSONA POR EDAD
		public List<persona> findByEdad(int edad);
	
	
}
