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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="solicitudes",schema="datos_puros")
public class Solicitud {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_solicitud",nullable=false)
	private long id_solicitud;
	
	@Column(name="descripcion_solicitud",nullable=false)
	private String descripcion;
	
	@Column(name="estado",nullable=false)
	private boolean estado;
	
	@Column(name="fecha_limite")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fch_limite;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario_solicitud;
	
	@OneToOne(mappedBy="solicitud")
	@JoinColumn(name="id_incidencia")
	private Incidencia incidencia;

	//Geters y Seters
	public long getId_solicitud() {
		return id_solicitud;
	}

	public void setId_solicitud(long id_solicitud) {
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

	public Solicitud() {
		super();
	}

	public Solicitud(long id_solicitud, String descripcion, boolean estado, Calendar fch_limite) {
		super();
		this.id_solicitud = id_solicitud;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fch_limite = fch_limite;
	}

	public Solicitud(String descripcion, boolean estado, Calendar fch_limite) {
		super();
		this.descripcion = descripcion;
		this.estado = estado;
		this.fch_limite = fch_limite;
	}
	
	
	

	
	
	

	
	
	
	
}
