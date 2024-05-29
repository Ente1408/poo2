package com.ppooii.trabajot1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppooii.trabajot1.Services.CoordenasServicelmpl;
import com.ppooii.trabajot1.entities.Coordenadas;

@RestController
@RequestMapping("/coordenada")
public class CoordenadasController {
	//INYECCION DEL SERVICE
	@Autowired
	@Qualifier("CoordenadasService")
	private CoordenasServicelmpl coordenadaService;
	
	//METODOS HTTP
	//METODO GET
	@CrossOrigin(origins="http://localhost")
	@GetMapping("/coorde")
	public List<Coordenadas> consultarAllCoordenadas(Pageable pageable){
		return coordenadaService.consultarAllCoordenadas(pageable);
	}
	
}
