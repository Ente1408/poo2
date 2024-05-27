package com.ppooii.trabajot1.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ppooii.trabajot1.entities.Usuario;


@Repository("IUsuarioRepo")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>, PagingAndSortingRepository <Usuario, Serializable> {

	public abstract Usuario findByLogin(String Login);
}
