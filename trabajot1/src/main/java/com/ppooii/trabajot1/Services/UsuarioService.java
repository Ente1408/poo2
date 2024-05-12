package com.ppooii.trabajot1.Services;

import org.springframework.stereotype.Service;

import com.ppooii.trabajot1.Services.Interfaces.GeneralService;
import com.ppooii.trabajot1.entities.Usuario;

@Service("GenService")
public class UsuarioService implements GeneralService {

	@Override
	public boolean changePassword(Usuario User) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getPassAndKey(Usuario User) {
		// TODO Auto-generated method stub
		return false;
	}

}
