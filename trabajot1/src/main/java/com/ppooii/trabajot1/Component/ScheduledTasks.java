package com.ppooii.trabajot1.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ppooii.trabajot1.APIs.GoogleMaps.Geocoder;
import com.ppooii.trabajot1.entities.Coordenadas;
import com.ppooii.trabajot1.entities.Persona;
import com.ppooii.trabajot1.repository.CoordenadasRepository;
import com.ppooii.trabajot1.repository.PersonaRepository;

@Component
public class ScheduledTasks {
	//Log de Errores
			private static Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
			private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			
	//INYECCION DE DEPENDENCIAS
		@Autowired
		@Qualifier("IPersonaRepo")
		private PersonaRepository IPersonaRepository;
		
		@Autowired
		@Qualifier("ICoordenadasRepository")
		private CoordenadasRepository ICoordenadaRepository;
		

		@Scheduled (cron = "*/30 * * * * ?")
		public void scheduleTaskWithCronExpression() {
			logger.info("Cron Task :: Execution Time . {}",dateTimeFormatter.format(LocalDateTime.now()));
			try {
				List<Persona> listPersonas = IPersonaRepository.findAll();
				if(listPersonas != null) {
					if(listPersonas.size() > 0) {
						Geocoder geocoder = new Geocoder();
						Coordenadas coorXper = new Coordenadas();
						for (Persona persona : listPersonas) {
							
							String LantLng = geocoder.getLatLng(persona.getUbicacion());
							String[] coor = LantLng.split(",");
							logger.info(LantLng+" - {}",dateTimeFormatter.format(LocalDateTime.now()));
							
							coorXper = ICoordenadaRepository.getCoordenadaXPersona(persona.Id);
							
							if(coorXper == null) {
								ICoordenadaRepository.save(new Coordenadas(persona.Id,persona.getPrimerApellido(),
										Double.parseDouble(coor[0].toString()),
										Double.parseDouble(coor[1].toString())));
							}else if (coorXper.id > 0) {
								ICoordenadaRepository.save(new Coordenadas(coorXper.id,persona.Id,persona.getPrimerApellido(),
										Double.parseDouble(coor[0].toString()),
										Double.parseDouble(coor[1].toString())));								
							}
						}
					}
				}
				
			}catch(Exception e) {
				System.out.print(e.getMessage());
			}
		}
}
