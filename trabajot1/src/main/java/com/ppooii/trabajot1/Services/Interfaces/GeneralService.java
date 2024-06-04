package com.ppooii.trabajot1.Services.Interfaces;

import com.ppooii.trabajot1.entities.Usuario;

public interface GeneralService {
	
	public boolean changePassword(Usuario User, String NewPassword);
	
	public boolean getPassAndKey(Usuario User);
	
	
}
