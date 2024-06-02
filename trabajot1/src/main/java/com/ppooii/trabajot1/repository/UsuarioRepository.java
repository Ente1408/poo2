package com.ppooii.trabajot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ppooii.trabajot1.entities.Usuario;
import com.ppooii.trabajot1.entities.UsuarioPK;


@Repository("IUsuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, UsuarioPK>, CrudRepository<Usuario, UsuarioPK> {

	@Query("SELECT usr FROM usuarios as usr WHERE usr.id.login = :login AND usr.id.id_personas = :persona")
	public abstract Usuario getUsuarioAndPersona(@Param("login") String login,@Param("persona") int persona);
	
	@Query("SELECT usr FROM usuarios as usr WHERE usr.id.login = :login")
	public abstract Usuario findByUsername(@Param("login") String login);
	
}
