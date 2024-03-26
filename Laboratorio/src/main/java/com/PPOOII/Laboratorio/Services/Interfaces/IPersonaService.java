package com.PPOOII.Laboratorio.Services.Interfaces;
import java.awt.print.Pageable;
import java.util.List;
import com.PPOOII.Laboratorio.Entities.Persona;

public interface IPersonaService {
	//METODOS CRUD
	
	public boolean guardar(Persona persona);
	
	public boolean actualizar(Persona persona);
	
	public boolean eliminar(int id);
	
	public List<Persona> consultarPersona (Pageable pageble);
	
	//LISTA DE PERSONAS POR ID 
	public Persona finById(int id);
	
	//LISTA DE PERSONA POR PRIMER NOMBRE
	public List<Persona> findByNombre(String pnombre);
	
	//LISTA DE PERSONA POR EDAD
	public List<Persona> findByEdad(int edad);

}
