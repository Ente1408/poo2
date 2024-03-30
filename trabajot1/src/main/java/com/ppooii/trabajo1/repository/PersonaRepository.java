package com.ppooii.trabajo1.repository;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ppooii.trabajo1.entities.persona;

public interface PersonaRepository extends JpaRepository<persona, Serializable>, PagingAndSortingRepository <persona, Serializable> {

	public abstract persona findById(int id);
	
	public abstract List<persona> findByPNombre(String pnombre);
	
	public abstract List<persona> findByEdad(int edad);
	
	public abstract Page findAll(Pageable pageable);
}

//dijiste que dejara el repositorio en blanco pero pude poner bien lo que decia en el laboratorio, si no sirve solo quitalo