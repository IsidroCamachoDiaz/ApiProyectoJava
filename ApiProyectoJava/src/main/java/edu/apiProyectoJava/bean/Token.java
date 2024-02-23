package edu.apiProyectoJava.bean;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * Clase que representa un token de autenticación en el sistema.
 * 
 * Esta clase mapea la entidad 'tokens' de la base de datos.
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param idToken Identificador único del token.
 * @param token Valor del token.
 * @param fch_limite Fecha límite de validez del token.
 * @param usuario Usuario asociado al token.
 */

@Entity
@Table(name="tokens",schema="personal_datos")
public class Token {
	
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_token", nullable=false)
	private int idToken;
		
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

	public void setIdToken(int idToken) {
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
	
	/**
	 * Crea una nueva instancia de Token sin inicializar sus atributos.
	 */
	public Token() {
		super();
	}
	
	/**
	 * Crea una nueva instancia de Token con los atributos especificados.
	 *
	 * @param token El token asociado.
	 * @param fch_limite La fecha límite del token.
	 * @param id_usuario El usuario asociado al token.
	 */
	public Token(String token, Calendar fch_limite,Usuario id_usuario) {
		super();
		this.token = token;
		this.fch_limite = fch_limite;
		this.usuario=id_usuario;
	}
}
