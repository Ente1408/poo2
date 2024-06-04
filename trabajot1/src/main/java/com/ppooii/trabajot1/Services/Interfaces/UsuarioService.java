package com.ppooii.trabajot1.Services.Interfaces;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
	public boolean getPassAndKey(Usuario User) {
		// TODO Auto-generated method stub
		return false;
	}

}
