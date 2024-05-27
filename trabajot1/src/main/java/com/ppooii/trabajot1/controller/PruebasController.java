package com.ppooii.trabajot1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ppooii.trabajot1.Trabajot1Application;
import com.ppooii.trabajot1.entities.Persona;

@RestController
public class PruebasController {
	private final Logger logger = LoggerFactory.getLogger(Trabajot1Application.class);
	
	@GetMapping("/hola")
	String miPrimeraRuta() {
		return "Hola mundo desde spring controller :)";
	}

	@GetMapping("/libro/{id}/editorial/{editorial}")
	String leerLibro(@PathVariable int id, @PathVariable String editorial) {
		return "Leyendo el libro id: "+id+" con la editorial: "+editorial;
	}
	
	@GetMapping("/libro/{id}")
	String leerLibro2(@PathVariable int id,@RequestParam String params ) {
		return "Leyendo el libro id: "+id+" estos son los parametros "+ params;
	}
	@PostMapping("/persona")
	String GuardarLibro(@RequestBody Persona persona) {
		
			logger.info("llave {} valor {}",persona.getPrimerNombre(),persona.getSegundoNombre());
		
		return "Hola Mundo post";
	}

	@GetMapping("/saludar")
	@ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY,reason = "Fue movida a la version de API Numero 2")
	String miSegundaRuta() {
		
		return "Aprendiendo statuse http en Spring Boot";
	}
	
	@GetMapping("/animales/{lugar}")
	public ResponseEntity<String> getAnimales(@PathVariable String lugar){
		if(lugar.equals("granga")) {
			return ResponseEntity.status(HttpStatus.OK).body("caballo,abeja,vaca");
			
		}else if(lugar.equals("selva")) {
			return ResponseEntity.status(HttpStatus.OK).body("mono,gorila,puma");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lugar no valido");
		}
	}
	
	@GetMapping("/calcular/{nuemro}")
	public int getCalculo(@PathVariable int numero) {
		throw new NullPointerException("La clave del usuario no es correcta, por que es 1234");
	}

}
