package com.ppooii.trabajot1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppooii.trabajot1.Services.Interfaces.UsuarioService;
import com.ppooii.trabajot1.entities.Usuario;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	@Qualifier("GenService")
	UsuarioService usuario; 
	
	
	//METODO PUT PARA CAMBIO DE CONTRASEÑA
	@PutMapping("/usuario/change/password")
	public boolean editarPersona(@RequestBody @Validated Usuario user){
		return false;
	}
	
	@GetMapping("/login")
	public String log_in() {
		return "Hello Word From end";
	}
}
