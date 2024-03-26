package com.PPOOII.Laboratorio.Repository;


import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.PPOOII.Laboratorio.Entities.Persona;

@Repository("IPersonaRepo")
public interface PersonaRepository extends JpaRepository<Persona, Serializable>, PagingAndSortingRepository <Persona, Serializable> {

	public abstract Persona findById(int id);
	
	public abstract List<Persona> findByPNombre(String pnombre);
	
	public abstract List<Persona> findByEdad(int edad);
	
	public abstract Page findAll(Pageable pageable);
}
