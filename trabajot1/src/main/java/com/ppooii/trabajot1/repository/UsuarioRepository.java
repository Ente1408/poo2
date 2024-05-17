package com.ppooii.trabajot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ppooii.trabajot1.entities.Usuario;
import com.ppooii.trabajot1.entities.UsuarioPK;


@Repository("IUsuarioRepo")
public interface UsuarioRepository extends JpaRepository<Usuario, UsuarioPK>, PagingAndSortingRepository <Usuario, UsuarioPK> {

	@Query("SELECT usr FROM UserAndPersona as usr WHERE usr.id.login = :login AND usr.id.persona = :persona")
	public abstract Usuario getUsuarioANDPersona(@Param("login") String login,@Param("persona") int persona);
	
	@Query("SELECT usr FROM UserAndPersona as usr WHERE usr.id.login = :login")
	public abstract Usuario findByUserName(@Param("login") String login);
	
}
