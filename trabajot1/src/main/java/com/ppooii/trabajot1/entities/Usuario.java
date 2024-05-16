package com.ppooii.trabajot1.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "UserAndPersona")
@Table(name = "usuarios",schema = "ppooii")
public class Usuario  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UsuarioPK id;	
		
	@Column(name = "pass")
	private String password;
	
	@Column(name = "apikey")
	private String apikey;

	@OneToOne
	@JoinColumn(name="id_personas")
	private Persona person;
	
	public Usuario() {}
	
	public Usuario(String login,String password) {
		super();
		this.id.setLogin(login) ;
		this.password = password;
	}


	public UsuarioPK getId() {
		return id;
	}


	public void setId(UsuarioPK iid) {
		id = iid;
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
