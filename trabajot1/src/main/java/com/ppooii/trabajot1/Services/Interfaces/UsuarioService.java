package com.ppooii.trabajot1.Services.Interfaces;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ppooii.trabajot1.entities.Persona;
import com.ppooii.trabajot1.entities.Usuario;
import com.ppooii.trabajot1.repository.UsuarioRepository;

import ch.qos.logback.classic.Logger;

@Service("UsuarioService")
public class UsuarioService implements GeneralService {
	
	@Autowired
	@Qualifier("IUsuarioRepo")
	private UsuarioRepository IUsuarioRepository;
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(UsuarioService.class);
	
	@Override
	public boolean changePassword(Usuario User, String NewPassword) {
		if(User.getPassword() == NewPassword || NewPassword == null) {
			logger.error("ERROR CAMBIAR CONTRASENA: LA CONTRASENA ES NULA O YA EXISTE");
			return false;
		}else {
			User.setPassword(NewPassword);
			IUsuarioRepository.save(User);
			return true;
		}
		
	}
	@Override
	public boolean change(String pass, String login ) {
		if(pass == null || login == null) {
			logger.error("ERROR CAMBIAR CONTRASENA: LA CONTRASENA ES NULA O YA EXISTE");
			return false;
		}
		Usuario user = IUsuarioRepository.findByLogin(login);
		
		user.setPassword(pass);
		IUsuarioRepository.save(user);
		return true;
	}

	@Override
	public boolean getPassAndKey(Usuario User) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Usuario> consultarUsuario(Pageable pageable) {
		return IUsuarioRepository.findAll(pageable).getContent();
	}
	
}
