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

@Entity
@Table(name="incidencias")
public class Incidencia {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_incidencia",nullable=false)
	private long id_incidencia;
	
	@Column(name="descripcion_incidencia",nullable=false)
	private String descripcion;
	
	@Column(name="horas_incidencia",nullable=false)
	private int horas;
	
	@Column(name="coste_incidencia",nullable=false)
	private float coste;
	
	@Column(name="fecha_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha_inicio;
	
	@Column(name="fecha_fin")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha_fin;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario empleado;
	
	@ManyToOne
	@JoinColumn(name="id_solicitud")
	private Solicitud solicitud;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_incidencia")
	private TipoIncidencia tipo;

	//Geters y Seters
	
	public long getId_incidencia() {
		return id_incidencia;
	}

	public void setId_incidencia(long id_incidencia) {
		this.id_incidencia = id_incidencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public float getCoste() {
		return coste;
	}

	public void setCoste(float coste) {
		this.coste = coste;
	}

	public Calendar getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Calendar fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Calendar getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Calendar fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Usuario getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Usuario empleado) {
		this.empleado = empleado;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public TipoIncidencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoIncidencia tipo) {
		this.tipo = tipo;
	}
	
	// Constructores

	public Incidencia(long id_incidencia, String descripcion, int horas, float coste, Calendar fecha_inicio,
			Calendar fecha_fin, Usuario empleado, Solicitud solicitud, TipoIncidencia tipo) {
		super();
		this.id_incidencia = id_incidencia;
		this.descripcion = descripcion;
		this.horas = horas;
		this.coste = coste;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.empleado = empleado;
		this.solicitud = solicitud;
		this.tipo = tipo;
	}

	public Incidencia() {
		super();
	}

	public Incidencia(String descripcion, int horas, float coste, Calendar fecha_inicio, Usuario empleado,
			Solicitud solicitud, TipoIncidencia tipo) {
		super();
		this.descripcion = descripcion;
		this.horas = horas;
		this.coste = coste;
		this.fecha_inicio = fecha_inicio;
		this.empleado = empleado;
		this.solicitud = solicitud;
		this.tipo = tipo;
	}
	

	
	
	
	

}
