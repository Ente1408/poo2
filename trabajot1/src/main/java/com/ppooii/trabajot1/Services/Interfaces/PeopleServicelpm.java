package com.ppooii.trabajot1.Services.Interfaces;

import java.awt.print.Pageable;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ppooii.trabajot1.entities.persona;
import com.ppooii.trabajot1.repository.PersonaRepository;

@Service
public class PeopleServicelpm implements IPeopleService {
	
	@Autowired
	private PersonaRepository PersonaRepo;
	//=============LOGS =============
	//LOGS DE ERRORES
	//log de error, no entendi esto, necesitare explicacion, lo dejo en // porque asi estaba pero ni idea
		//private static final EventLogger Logger = org.apache.loggin.log4j.LogManager.getLogger(PersonaServiceImpl.class);
	
	//INSERT
	@Override
	public boolean guardar(persona persona) {
		try {
			if(persona == null){
				//logger.error("ERROR AGREGAR_PERSONA: LA PERSONA ES NULO");
				return false;
			}
				int edad = calcularAniosCalendar(persona.getFechaNacimiento());
				if(edad == 0) {
					return false;
				}
			    persona.setEdad(edad);
			    
			    String EdadClinica = calcularEdadClinica(persona.getFechaNacimiento());
			    
				if(EdadClinica == null) {
					return false;
				}
			    persona.setEdadClinica(EdadClinica);
			    
			    PersonaRepo.save(persona);
				return true;
			
		}catch(Exception e) {
			//logger.error("ERROR AGREGAR_PERSONA: LA PERSONA NO SE HA GUARDADO");
			return false;
		}
	}
	
	@Override
	public boolean actualizar(persona persona) {
		try {
			if((persona == null) || (persona.getId() == 0)) {
				//logger.error("ERROR EDITAR_PERSONA: : LA PERSONA ES NULO O EL ID ES 0");
				return false;
			}
			else {
				PersonaRepo.save(persona);
				return true;
			}
		}catch(Exception e) {
			//logger.error("ERROR EDITAR_PERSONA: LA PERSONA NO SE HA EDITADO");
			return false;
		}
	}
	
	@Override
	public boolean eliminar(int id) {
		try {
			if((id == 0)) {
				//logger.error("ERROR ELIMINAR_ PERSONA: EL ID DE LA PERSONA ES 0");
				return false;
			}
			else {
				persona persona = PersonaRepo.findById(id);
				PersonaRepo.delete(persona);
				return true;
			}
		}catch(Exception e) {
			//logger.error("ERROR EDITAR_PERSONA: LA PERSONA NO SE HA EDITADO");
			return false;
		}
		
	}
	
	@Override
	public List<persona> consultarPersona (Pageable pageable){
		return (List<persona>) PersonaRepo.findAll(pageable);
	}
	
	@Override
	public persona finById(int id) {
		return PersonaRepo.findById(id);
	}
	
	@Override
	public List<persona> findByNombre(String pnombre) {
		return PersonaRepo.findByPNombre(pnombre);
	}
	
	@Override	
	public List<persona> findByEdad(int edad){
		return PersonaRepo.findByEdad(edad);
	}
	
	private static String calcularEdadClinica(Date fecha) {
        // Seteamos el dia mes y año
        Calendar inicio = Calendar.getInstance();
        inicio.setTime(fecha);
 
        // Dia actual
        Calendar actual = Calendar.getInstance();
      
        ZoneId defaultZoneId = ZoneId.systemDefault();
        
        Instant inic = inicio.getTime().toInstant();
        LocalDate localInicio = inic.atZone(defaultZoneId).toLocalDate();
        
        Instant actu = actual.getTime().toInstant();
        LocalDate localActu= actu.atZone(defaultZoneId).toLocalDate();     
        
        Period Periodo  = Period.between(localInicio, localActu);

		return Periodo.getYears()+" Años, "+ Periodo.getMonths()+" Meses, "+ Periodo.getDays()+" Dias";
	}
    private static int calcularAniosCalendar(Date fecha) {
    	
    	 
        // Seteamos el dia mes y año
        Calendar inicio = Calendar.getInstance();
        inicio.setTime(fecha);
 
        // Dia actual
        Calendar actual = Calendar.getInstance();
 
        // Calcula la diferencia de años
        int diferencia = actual.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
 
        // Si la diferencia de años es 0, no hay que restar nada
        // Si el año del dia de la fecha que yo paso es mayor que la actual, resto uno
        if (diferencia != 0 && inicio.get(Calendar.DAY_OF_YEAR) > actual.get(Calendar.DAY_OF_YEAR)) {
            diferencia--;
        }
 
        return diferencia;
 
    }
	
}
