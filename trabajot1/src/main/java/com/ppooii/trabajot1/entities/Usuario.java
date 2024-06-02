package com.ppooii.trabajot1.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios",schema = "ppooii")
public class Usuario  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UsuarioPK id_usuarios;	
		
	@Column(name = "pass")
	private String password;
	
	@Column(name = "apikey")
	private String apikey;
	
	public Usuario() {}
	
	public Usuario(String login,String password,String apikey) {
		super();
		this.id_usuarios.setLogin(login) ;
		this.password = password;
		this.apikey = apikey;
	}


	public UsuarioPK getId() {
		return id_usuarios;
	}


	public void setId(UsuarioPK iid) {
		id_usuarios = iid;
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
