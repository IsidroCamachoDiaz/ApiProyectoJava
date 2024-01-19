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
@Table(name="incidencias")
public class Incidencia {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_incidencia",nullable=false)
	private long id_incidencia;
	
	@Column(name="descripcion_usuario",nullable=false)
	private String descripcion_usuario;
	
	@Column(name="descripcion_tecnica")
	private String descripcion_tecnica;
	
	@Column(name="horas_incidencia")
	private int horas;
	
	@Column(name="coste_incidencia")
	private float coste;
	
	@Column(name="estado_incidencia",nullable=false)
	private boolean estado;
	
	@Column(name="fecha_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha_inicio;
	
	@Column(name="fecha_fin")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha_fin;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario empleado;
	
	@OneToOne
	@JoinColumn(name="id_solicitud")
	private Solicitud solicitud;
	
	 @OneToMany(mappedBy="incidencia")
	 List<Trabajo> trabajosConIncidencias;   

	//Geters y Seters
	
	public long getId_incidencia() {
		return id_incidencia;
	}

	public void setId_incidencia(long id_incidencia) {
		this.id_incidencia = id_incidencia;
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
	public String getDescripcion_usuario() {
		return descripcion_usuario;
	}

	public void setDescripcion_usuario(String descripcion_usuario) {
		this.descripcion_usuario = descripcion_usuario;
	}

	public String getDescripcion_tecnica() {
		return descripcion_tecnica;
	}

	public void setDescripcion_tecnica(String descripcion_tecnica) {
		this.descripcion_tecnica = descripcion_tecnica;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	// Constructores

	public Incidencia() {
		super();
	}

	public Incidencia(long id_incidencia, String descripcion_usuario, String descripcion_tecnica, int horas,
			float coste, boolean estado, Calendar fecha_inicio, Calendar fecha_fin) {
		super();
		this.id_incidencia = id_incidencia;
		this.descripcion_usuario = descripcion_usuario;
		this.descripcion_tecnica = descripcion_tecnica;
		this.horas = horas;
		this.coste = coste;
		this.estado = estado;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	public Incidencia(String descripcion_usuario, String descripcion_tecnica, int horas, float coste, boolean estado,
			Calendar fecha_inicio, Calendar fecha_fin) {
		super();
		this.descripcion_usuario = descripcion_usuario;
		this.descripcion_tecnica = descripcion_tecnica;
		this.horas = horas;
		this.coste = coste;
		this.estado = estado;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}
	
	


	
	


	

	
	
	
	

}
