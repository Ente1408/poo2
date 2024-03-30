package com.ppooii.trabajo1.entities;

import java.io.Serializable;
import java.sql.Date;


public class persona implements Serializable {
	public int Id;
	private int identificacion;
	private String PrimerNombre;
	private String SegundoNombre;
	private String PrimerApellido;
	private String SegundoApellido;
	private String Email;
	private Date FechaNacimiento;
	private int Edad;
	private String EdadClinica;
	
	public persona () {};
	
	// aqui no pongo id porque, si lo pongo ahi, es un dato que ellos tienen que poner, 
	//y si el id es autoincrementable entonces ellos no pueden ponerlo al ingresar una persona, cieto?
	
	//lo de edad clinica, ya veremos
	
	public persona (int identificacion, String PrimerNombre, int Edad, String PrimerApellido, String Email, Date FechaNacimiento) {
		super();
		this.identificacion = identificacion;
		this.PrimerNombre = PrimerNombre;
		this.Edad = Edad;
		this.PrimerApellido = PrimerApellido;
		this.Email = Email;
		this.FechaNacimiento = FechaNacimiento;
		
	}
	
	public persona (int identificacion, String PrimerNombre, String SegundoNombre,  int Edad, String PrimerApellido, String Email, Date FechaNacimiento) {
		super();
		this.identificacion = identificacion;
		this.PrimerNombre = PrimerNombre;
		this.SegundoNombre = SegundoNombre;
		this.Edad = Edad;
		this.PrimerApellido = PrimerApellido;
		this.Email = Email;
		this.FechaNacimiento = FechaNacimiento;
		
	}
	
	public persona (int identificacion, String PrimerNombre, int Edad, String PrimerApellido, String SegundoApellido, String Email, Date FechaNacimiento) {
		super();
		this.identificacion = identificacion;
		this.PrimerNombre = PrimerNombre;
		this.Edad = Edad;
		this.PrimerApellido = PrimerApellido;
		this.SegundoApellido = SegundoApellido;
		this.Email = Email;
		this.FechaNacimiento = FechaNacimiento;
		
	}
	
	public persona (int identificacion, String PrimerNombre, String SegundoNombre,  int Edad, String PrimerApellido, String SegundoApellido, String Email, Date FechaNacimiento) {
		super();
		this.identificacion = identificacion;
		this.PrimerNombre = PrimerNombre;
		this.SegundoNombre = SegundoNombre;
		this.Edad = Edad;
		this.PrimerApellido = PrimerApellido;
		this.SegundoApellido = SegundoApellido;
		this.Email = Email;
		this.FechaNacimiento = FechaNacimiento;
		
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
		return PrimerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		PrimerNombre = primerNombre;
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
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getEdadClinica() {
		return EdadClinica;
	}

	public void setEdadClinica(String edadClinica) {
		EdadClinica = edadClinica;
	}
	
	public String toString() {
		return "Persona [id = "+this.Id+
				", Primer Nombre = "+this.PrimerNombre+", Segundo Nombre = "+this.SegundoNombre+
				", Edad = "+this.Edad+", Primer Apellido = "+this.PrimerApellido+", Segundo Apellido = "+this.SegundoApellido+
				", Email = "+this.Email+", Fecha Nacimiento = "+this.FechaNacimiento+", Edad Clinica = "+this.EdadClinica+"]";
	}
	
	
}

