package com.PPOOII.Laboratorio.Entities;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

	@Entity
	@Table(name="Persona",schema = "PPOOII")
	
public class Persona  implements Serializable{


		@GeneratedValue(strategy = GenerationType.IDENTITY)
	
		@Column(name="ID")
		public int Id;
		
		@Column(name="PNombre")
		private String PNombre;
		
		@Column(name="Edad")
		private int Edad;
		
		public Persona() {}
		
		public Persona (String PNombre, int Edad) {
			super();
			this.PNombre = PNombre;
			this.Edad = Edad;
		}
		
		public Persona (int Id , String PNombre, int Edad) {
			super();
			this.Id = Id;
			this.PNombre = PNombre;
			this.Edad = Edad;
		}
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public String getPNombre() {
			return PNombre;
		}
		public void setPNombre(String pNombre) {
			PNombre = pNombre;
		}
		public int getEdad() {
			return Edad;
		}
		public void setEdad(int edad) {
			Edad = edad;
		}
		
		
		@Override
		public String toString() {
			return "Persona [id = "+this.Id+", Primer Nombre = "+this.PNombre+", Edad = "+this.Edad+"]";
					
		}
		
		
		
		
		
}
