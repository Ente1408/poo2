package com.ppooii.trabajot1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ppooii.trabajot1.Services.Interfaces.UsuarioService;
import com.ppooii.trabajot1.entities.Usuario;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	@Qualifier("UsuarioService")
	UsuarioService usuario; 
	
	
	//METODO PUT PARA CAMBIO DE CONTRASEÑA
	@PutMapping("/usuario/change/password/{NewPassword}")
	public boolean changePassword(@RequestBody @Validated Usuario user, @RequestParam @Validated String NewPassword){
		return usuario.changePassword(user, NewPassword);
	}
	
	@PutMapping("/user/change/pass/{NewPassword}/{login}")
	public boolean change(@PathVariable("login") String login, @PathVariable("NewPassword") String NewPassword) {
		return usuario.change(NewPassword, login);
	}
	
	@GetMapping("/login")
	public String log_in() {
		return "Hello Word From end";
	}
	
	//METODO BUSQUEDA
	@GetMapping("/Usuario")
	public List<Usuario> ListadoUsuario(Pageable pageable){
		return usuario.consultarUsuario(pageable);
	}
	
}
