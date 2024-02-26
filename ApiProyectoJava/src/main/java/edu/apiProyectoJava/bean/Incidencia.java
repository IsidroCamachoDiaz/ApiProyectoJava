package edu.apiProyectoJava.bean;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
/**
 * Clase que representa una incidencia registrada en el sistema.
 * 
 * Esta clase mapea la entidad 'incidencias' de la base de datos.
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param id_incidencia Identificador único de la incidencia.
 * @param descripcion_usuario Descripción de la incidencia proporcionada por el usuario.
 * @param descripcion_tecnica Descripción técnica de la incidencia.
 * @param horas Cantidad de horas dedicadas a resolver la incidencia.
 * @param coste Coste asociado a la incidencia.
 * @param estado Estado actual de la incidencia.
 * @param fecha_inicio Fecha y hora de inicio de la incidencia.
 * @param fecha_fin Fecha y hora de resolución de la incidencia.
 * @param empleado Usuario asignado a la incidencia.
 * @param solicitud Solicitud asociada a la incidencia.
 * @param trabajosConIncidencias Lista de trabajos relacionados con esta incidencia.
 */
@Entity
@Table(name="incidencias",schema="datos_puros")
public class Incidencia {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_incidencia",nullable=false)
	private int id_incidencia;
	
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
	@JsonIgnoreProperties(value={"incidencias_empleado"},allowSetters=true)
	private Usuario empleado;
	
	@OneToOne
	@JoinColumn(name="id_solicitud")
	private Solicitud solicitud;
	
	 @OneToMany(mappedBy="incidencia")
	 List<Trabajo> trabajosConIncidencias;   

	//Geters y Seters
	
	public int getId_incidencia() {
		return id_incidencia;
	}

	public void setId_incidencia(int id_incidencia) {
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
	
	/**
	 * Crea una nueva instancia de Incidencia sin inicializar sus atributos.
	 */
	public Incidencia() {
		super();
	}
	
	/**
	 * Crea una nueva instancia de Incidencia con los atributos especificados.
	 *
	 * @param id_incidencia       Identificador único de la incidencia.
	 * @param descripcion_usuario Descripción de la incidencia proporcionada por el usuario.
	 * @param descripcion_tecnica Descripción técnica de la incidencia.
	 * @param horas               Horas dedicadas a resolver la incidencia.
	 * @param coste               Coste asociado a la incidencia.
	 * @param estado              Estado de la incidencia (resuelta o no resuelta).
	 * @param fecha_inicio        Fecha de inicio de la incidencia.
	 * @param fecha_fin           Fecha de finalización de la incidencia.
	 */
	public Incidencia(int id_incidencia, String descripcion_usuario, String descripcion_tecnica, int horas,
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
	
	/**
	 * Crea una nueva instancia de Incidencia con los atributos especificados, excluyendo el identificador único.
	 *
	 * @param descripcion_usuario Descripción de la incidencia proporcionada por el usuario.
	 * @param descripcion_tecnica Descripción técnica de la incidencia.
	 * @param horas               Horas dedicadas a resolver la incidencia.
	 * @param coste               Coste asociado a la incidencia.
	 * @param estado              Estado de la incidencia (resuelta o no resuelta).
	 * @param fecha_inicio        Fecha de inicio de la incidencia.
	 * @param fecha_fin           Fecha de finalización de la incidencia.
	 */
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
	
	/**
	 * Crea una nueva instancia de Incidencia con los atributos especificados, excluyendo el identificador único
	 * y la fecha de finalización.
	 *
	 * @param descripcion_usuario Descripción de la incidencia proporcionada por el usuario.
	 * @param estado              Estado de la incidencia (resuelta o no resuelta).
	 * @param solicitud           Solicitud asociada a la incidencia.
	 */
	public Incidencia(String descripcion_usuario, boolean estado, Solicitud solicitud) {
		super();
		this.descripcion_usuario = descripcion_usuario;
		this.estado = estado;
		this.solicitud = solicitud;
	}
	
	
	
	


	
	


	

	
	
	
	

}
