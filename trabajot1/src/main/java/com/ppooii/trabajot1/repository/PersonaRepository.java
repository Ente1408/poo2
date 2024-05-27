package com.ppooii.trabajot1.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ppooii.trabajot1.entities.Persona;

@Repository("IPersonaRepo")
public interface PersonaRepository extends JpaRepository<Persona, Serializable>, PagingAndSortingRepository <Persona, Serializable> {

	public abstract Persona findAllById(int Id);
		
	public abstract List<Persona> findAllByPNombre(String PNombre);
	
	public abstract List<Persona> findByEdad(int edad);
	
	public abstract Page<Persona> findAll(Pageable pageable);
}

