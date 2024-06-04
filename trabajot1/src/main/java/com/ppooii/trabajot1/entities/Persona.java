package com.ppooii.trabajot1.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ppooii.trabajot1.Services.Interfaces.PersonaServicelmpl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


@Entity
@Table(name = "persona",schema = "ppooii")
public class Persona implements Serializable {
	

	private static Logger logger = LoggerFactory.getLogger(PersonaServicelmpl.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Id;
	
	@Column(name = "identificacion") 
	private int identificacion;
	
	@Column(name = "primer_nombre")
	private String PNombre;
	
	@Column(name = "segundo_nombre")
	private String SegundoNombre;
	
	@Column(name = "primer_apellido")
	private String PrimerApellido;
	
	@Column(name = "segundo_apellido")
	private String SegundoApellido;
	
	@Column(name = "email")
	private String Email;
	
	@Column(name = "fecha_nacimiento")
	private Date FechaNacimiento;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "edadclinica")
	private String EdadClinica;
	
	@OneToOne(mappedBy = "person")
	private Usuario user;
	
	// aqui no pongo id porque, si lo pongo ahi, es un dato que ellos tienen que poner, 
	//y si el id es autoincrementable entonces ellos no pueden ponerlo al ingresar una persona, cieto?
	
	//lo de edad clinica, ya veremos
	
	public Persona (int identificacion, String PrimerNombre, int Edad, String PrimerApellido, String Email, Date FechaNacimiento) {
		super();
		this.identificacion = identificacion;
		this.PNombre = PrimerNombre;
		this.edad = Edad;
		this.PrimerApellido = PrimerApellido;
		this.Email = Email;
		this.FechaNacimiento = FechaNacimiento;
	}
	public Persona() {
		
	}
	public int getId() {
		return Id; //este debe tener getter y setter? o no?
	}

	public void setId(int id) {
		Id = id;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public String getPrimerNombre() {
		return PNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		PNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return SegundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		SegundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return PrimerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		PrimerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return SegundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		SegundoApellido = segundoApellido;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad1) {
		edad = edad1;
	}

	public String getEdadClinica() {
		return EdadClinica;
	}

	public void setEdadClinica(String edadClinica) {
		EdadClinica = edadClinica;
	}
	
	@Override
	public String toString() {
		return "Persona [id = "+this.Id+
				", Primer Nombre = "+this.PNombre+", Segundo Nombre = "+this.SegundoNombre+
				", Edad = "+this.edad+", Primer Apellido = "+this.PrimerApellido+", Segundo Apellido = "+this.SegundoApellido+
				", Email = "+this.Email+", Fecha Nacimiento = "+this.FechaNacimiento+", Edad Clinica = "+this.EdadClinica+"]";
	}
	
	
	@PrePersist
	public void beforePersist() {
		logger.info("Asignacion de edad y edad clinica");
        Instant instant = getFechaNacimiento().toInstant();
        LocalDate fechaNac = instant.atZone(ZoneId.systemDefault()).toLocalDate();

		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		setEdad(periodo.getYears());
		setEdadClinica(new String ("Tu edad es: "+periodo.getYears()+" años,"+periodo.getMonths()+" meses y "+periodo.getDays()+" días"));
	}
	
	@PreUpdate
	public void beforeupdate() {
		logger.info("Asignacion de edad y edad clinica antes de actualizar");
        Instant instant = getFechaNacimiento().toInstant();
        LocalDate fechaNac = instant.atZone(ZoneId.systemDefault()).toLocalDate();

		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		setEdad(periodo.getYears());
		setEdadClinica(new String ("Tu edad es: "+periodo.getYears()+" años,"+periodo.getMonths()+" meses y "+periodo.getDays()+" días"));
	}
	
	
}

