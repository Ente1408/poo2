package com.ppooii.trabajot1.Services.Interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ppooii.trabajot1.entities.Usuario;
import com.ppooii.trabajot1.entities.UsuarioPK;

public interface IUsuarioService {
	boolean guardar(Usuario usuario);
	
	boolean actualizar(Usuario usuario);
	
	boolean eliminar(UsuarioPK usuario);
	
	List<Usuario> consultarUsuario(Pageable pageable);
	
	Usuario getUsuarioById(UsuarioPK id);

	
}
