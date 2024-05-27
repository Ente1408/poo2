package com.ppooii.trabajot1.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="COOR")
@Table(name="Coordenadas",schema="PPOOII")
public class Coordenadas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id_coordenada")
	public int id;
	
	@Column(name="persona")
	public int persona;
	
	@Column(name = "marca")
	public String marca;
	
	@Column(name="")

}
