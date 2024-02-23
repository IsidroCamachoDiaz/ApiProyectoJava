package edu.apiProyectoJava.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/**
 * Clase que representa un trabajo asociado a una incidencia en el sistema.
 * 
 * Esta clase mapea la entidad 'trabajos' de la base de datos.
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param id_trabajo Identificador único del trabajo.
 * @param descripcion Descripción del trabajo.
 * @param estado Estado actual del trabajo.
 * @param horas Cantidad de horas dedicadas al trabajo.
 * @param incidencia Incidencia asociada al trabajo.
 * @param tipoIncidencia Tipo de incidencia asociada al trabajo.
 */

@Entity
@Table(name="trabajos",schema="datos_puros")
public class Trabajo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_trabajo",nullable=false)
	private int id_trabajo;
	
	@Column(name="descripcion_trabajo",nullable=false)
	private String descripcion;
	
	@Column(name="estado_trabajo",nullable=false)
	private boolean estado;
	
	@Column(name="horas_trabajo",nullable=false)
	private int horas;
	
	@ManyToOne
	@JoinColumn(name="id_incidencia")
	private Incidencia incidencia;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_incidencia")
	private TipoIncidencia tipoIncidencia;

	//Geteres y Seters
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	

	public Incidencia getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
	}

	public TipoIncidencia getTipoIncidencia() {
		return tipoIncidencia;
	}

	public void setTipoIncidencia(TipoIncidencia tipoIncidencia) {
		this.tipoIncidencia = tipoIncidencia;
	}
	
	

	public int getId_trabajo() {
		return id_trabajo;
	}

	public void setId_trabajo(int id_trabajo) {
		this.id_trabajo = id_trabajo;
	}

	//Constructores
	
	/**
	 * Crea una nueva instancia de Trabajo con los atributos especificados.
	 *
	 * @param id_trabajo Identificador único del trabajo.
	 * @param descripcion Descripción del trabajo.
	 * @param estado Estado del trabajo.
	 * @param horas Horas dedicadas al trabajo.
	 */
	public Trabajo(int id_trabajo, String descripcion, boolean estado, int horas) {
		super();
		this.id_trabajo = id_trabajo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.horas = horas;
	}
	
	/**
	 * Crea una nueva instancia de Trabajo con los atributos especificados, excluyendo el identificador único.
	 *
	 * @param descripcion Descripción del trabajo.
	 * @param estado Estado del trabajo.
	 * @param horas Horas dedicadas al trabajo.
	 */
	public Trabajo(String descripcion, boolean estado, int horas) {
		super();
		this.descripcion = descripcion;
		this.estado = estado;
		this.horas = horas;
	}

	/**
	 * Crea una nueva instancia de Trabajo sin inicializar sus atributos.
	 */
	public Trabajo() {
		super();
	}
		
}
