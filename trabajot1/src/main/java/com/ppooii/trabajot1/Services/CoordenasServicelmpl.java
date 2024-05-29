package com.ppooii.trabajot1.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ppooii.trabajot1.Services.Interfaces.ICoordenadasService;
import com.ppooii.trabajot1.entities.Coordenadas;
import com.ppooii.trabajot1.repository.CoordenadasRepository;

@Service("CoordenadasService")
public class CoordenasServicelmpl implements ICoordenadasService {

		//INYECCION DE DEPENDENCIAS
		@Autowired
		@Qualifier("ICoordenadasRepository")
		private CoordenadasRepository ICoordenadaRepository;
		
		//Log de Errores
		private static Logger logger = LoggerFactory.getLogger(PersonaServicelmpl.class);
		
		
		@Override
		public List<Coordenadas> consultarAllCoordenadas(Pageable pageable){
			return ICoordenadaRepository.findAll(pageable).getContent();
		}
}
