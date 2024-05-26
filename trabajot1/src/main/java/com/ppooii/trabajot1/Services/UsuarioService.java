package com.ppooii.trabajot1.Services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ppooii.trabajot1.Services.Interfaces.IUsuarioService;
import com.ppooii.trabajot1.entities.Usuario;
import com.ppooii.trabajot1.entities.UsuarioPK;
import com.ppooii.trabajot1.repository.UsuarioRepository;

@Service("GenService")
public class UsuarioService implements IUsuarioService, UserDetailsService {

	@Autowired
	@Qualifier("IUsuarioRepo")
	private UsuarioRepository IUsuarioRepository;
	
	private static Logger logger = LoggerFactory.getLogger(PersonaServicelmpl.class);
	
	//INSERT
	@Override
	public boolean guardar(Usuario usuario) {
		try {
			if(usuario == null) {
				logger.error("ERROR GUARDAR_USUARIO: EL USUARIO ES NULO!!");
				return false;
			}
			
			IUsuarioRepository.save(usuario);
			logger.info("AGREGAR USUARIO: USUARIO AGREGADA!");
			return true;
			
		}catch(Exception e) {
			logger.error("ERROR GUARDAR_USUARIO: EL USUARIO NO SE HA GUARDADO!!");
			return false;
		}
	}
	
	//UPDATE 
	@Override
	public boolean actualizar (Usuario usuario) {
		try {
			if((usuario == null)
					|| (usuario.getId().getPersona() == 0)
					|| (usuario.getId().getLogin().isEmpty())
					|| (usuario.getId().getLogin() == null)
					) {
				logger.error("ERROR EDITAR USUARIO:EL USUARIO ES NULL O EL ID ES 0 O EL LOGIN ES NULL!!");	
				return true;
			}
			
			IUsuarioRepository.save(usuario);
			return true;
			
		}catch(Exception e) {
			logger.error("ERROR EDITAR USUARIO: EL USUARIO NO SE HA EDITADO!!");
			return false;
		}
	}
	
	@Override
	public boolean eliminar(UsuarioPK id) {
		try {
			if((id.getPersona() == 0) || (id.getLogin().isEmpty() ) || (id.getLogin() == null)) {
				logger.error("ERROR ELIMINAR USUARIO:EL USUARIO ES NULL O EL ID ES 0 O EL LOGIN ES NULL!!");	
				return true;
			}
			
			Usuario usuario = IUsuarioRepository.getUserAndPersona(id.getLogin(), id.getPersona());
			IUsuarioRepository.delete(usuario);
			return true;
			
		}catch(Exception e) {
			logger.error("ERROR ELIMINAR USUARIO: EL USUARIO NO SE HA ELIMINADO!!");
			return false;
		}
	}
	@Override
	public List<Usuario> consultarUsuario(Pageable pageable){
		return IUsuarioRepository.findAll(pageable).getContent();
	}
	@Override
	public Usuario getUsuarioById(UsuarioPK id) {
		return IUsuarioRepository.getUserAndPersona(id.getLogin(), id.getPersona());
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.print("buscar el usuario con el repositorio y si no existe lanzar una exception");
		Usuario appUser = IUsuarioRepository.findByUserName(username);
		
		List grantList = new ArrayList();
		System.out.print("Cre el objeto para UserDetails que va a ir en sesion y retornarla");
		UserDetails user = (UserDetails) new User(appUser.getId().getLogin(),appUser.getPassword(),grantList);
		
		System.out.print("User:["+user+"]");
		
		return user;
	}




}
