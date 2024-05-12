package com.ppooii.trabajot1.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios",schema = "ppooii")
public class Usuario  implements Serializable {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "pass")
	private String password;
	
	@Column(name = "apikey")
	private String apikey;

	@OneToOne
	@JoinColumn(name="id_personas")
	private Persona person;
	
	public Usuario() {
		
	}
	
	
	public Usuario(String login, String password, String apikey, Persona person) {
		super();
		this.login = login;
		this.password = password;
		this.apikey = apikey;
		this.person = person;
	}


	public int getId() {
		return id;
	}


	public void setId(int iid) {
		id = iid;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String ilogin) {
		login = ilogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	
	
}
