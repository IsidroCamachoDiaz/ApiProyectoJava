package edu.apiProyectoJava.bean;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
/**
 * Clase que representa una solicitud realizada por un cliente en el sistema.
 * 
 * Esta clase mapea la entidad 'solicitudes' de la base de datos.
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param id_solicitud Identificador único de la solicitud.
 * @param descripcion Descripción de la solicitud.
 * @param estado Estado actual de la solicitud.
 * @param fch_limite Fecha límite para la realización de la solicitud.
 * @param cliente Usuario que realiza la solicitud.
 */

@Entity
@Table(name="solicitudes",schema="datos_puros")
public class Solicitud {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_solicitud",nullable=false)
	private int id_solicitud;
	
	@Column(name="descripcion_solicitud",nullable=false)
	private String descripcion;
	
	@Column(name="estado",nullable=false)
	private boolean estado;
	
	@Column(name="fecha_limite")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fch_limite;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="id_usuario")
	@JsonIgnoreProperties(value={"solicitudes_usuario"},allowSetters=true)
	private Usuario cliente;
	

	//Geters y Seters
	public long getId_solicitud() {
		return id_solicitud;
	}

	public void setId_solicitud(int id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Calendar getFch_limite() {
		return fch_limite;
	}

	public void setFch_limite(Calendar fch_limite) {
		this.fch_limite = fch_limite;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	//Constructores

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	/**
	 * Crea una nueva instancia de Solicitud sin inicializar sus atributos.
	 */
	public Solicitud() {
		super();
	}
	
	/**
	 * Crea una nueva instancia de Solicitud con los atributos especificados.
	 *
	 * @param id_solicitud Identificador único de la solicitud.
	 * @param descripcion Descripción de la solicitud.
	 * @param estado Estado de la solicitud.
	 * @param fch_limite Fecha límite de la solicitud.
	 * @param user Cliente asociado a la solicitud.
	 */
	public Solicitud(int id_solicitud, String descripcion, boolean estado, Calendar fch_limite,Usuario user) {
		super();
		this.id_solicitud = id_solicitud;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fch_limite = fch_limite;
		this.cliente=user;
	}
	
	/**
	 * Crea una nueva instancia de Solicitud con los atributos especificados, excluyendo el identificador único.
	 *
	 * @param descripcion Descripción de la solicitud.
	 * @param estado Estado de la solicitud.
	 * @param fch_limite Fecha límite de la solicitud.
	 * @param user Cliente asociado a la solicitud.
	 */
	public Solicitud(String descripcion, boolean estado, Calendar fch_limite,Usuario user) {
		super();
		this.descripcion = descripcion;
		this.estado = estado;
		this.fch_limite = fch_limite;
		this.cliente=user;
	}
	
	
	

	
	
	

	
	
	
	
}
