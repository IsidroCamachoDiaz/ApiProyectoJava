package edu.apiProyectoJava.bean;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="tokens",schema="personal_datos")
public class Token {
	
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_token", nullable=false)
	private long idToken;
		
	@Column(name="token", nullable=false)
	private String token;
		
	@Column(name="fecha_limite")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fch_limite;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	// GETTER / SETTER
	
	

	public long getIdToken() {
		return idToken;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setIdToken(long idToken) {
		this.idToken = idToken;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Calendar getFch_limite() {
		return fch_limite;
	}
	
	public void setFch_limite(Calendar fch_limite) {
		this.fch_limite = fch_limite;
	}
	
	// CONSTRUTORES
	public Token() {
		super();
	}

	public Token(String token, Calendar fch_limite,Usuario id_usuario) {
		super();
		this.token = token;
		this.fch_limite = fch_limite;
		this.usuario=id_usuario;
	}
}
