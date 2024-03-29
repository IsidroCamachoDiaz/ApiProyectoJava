package edu.apiProyectoJava.bean;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
/**
 * Clase que representa un tipo de incidencia en el sistema.
 * 
 * Esta clase mapea la entidad 'tipos_incidencias' de la base de datos.
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param id_tipo Identificador único del tipo de incidencia.
 * @param descripcion_tipo Descripción del tipo de incidencia.
 * @param precio_tipo Precio asociado al tipo de incidencia.
 * @param fecha_fin Fecha de expiración del tipo de incidencia.
 * @param trabajosConTipo Lista de trabajos asociados a este tipo de incidencia.
 */

@Entity
@Table(name="tipos_incidencias",schema="datos_puros")
public class TipoIncidencia {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo",nullable=false)
	private int id_tipo;
	
	@Column(name="descripcion_tipo",nullable=false)
	private String descripcion_tipo;
	
	@Column(name="precio_tipo",nullable=false)
	private float precio_tipo;
	
	@Column(name="fecha_expiracion")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha_fin;
	
	@OneToMany(mappedBy="tipoIncidencia")
	private List <Trabajo> trabajosConTipo;
	
	//Geteres y Seters
	
	public long getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getDescripcion_tipo() {
		return descripcion_tipo;
	}

	public void setDescripcion_tipo(String descripcion_tipo) {
		this.descripcion_tipo = descripcion_tipo;
	}

	public Calendar getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Calendar fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public float getPrecio_tipo() {
		return precio_tipo;
	}

	public void setPrecio_tipo(float precio_tipo) {
		this.precio_tipo = precio_tipo;
	}
	//Constructores
	
	/**
	 * Crea una nueva instancia de TipoIncidencia con los atributos especificados.
	 *
	 * @param id_tipo Identificador único del tipo de incidencia.
	 * @param descripcion_tipo Descripción del tipo de incidencia.
	 * @param precio_tipo Precio asociado al tipo de incidencia.
	 * @param fecha_fin Fecha de expiración del tipo de incidencia.
	 */
	public TipoIncidencia(int id_tipo, String descripcion_tipo, float precio_tipo, Calendar fecha_fin) {
		super();
		this.id_tipo = id_tipo;
		this.descripcion_tipo = descripcion_tipo;
		this.precio_tipo = precio_tipo;
		this.fecha_fin = fecha_fin;
	}
	
	/**
	 * Crea una nueva instancia de TipoIncidencia sin inicializar sus atributos.
	 */
	public TipoIncidencia() {
		super();
	}
	
	/**
	 * Crea una nueva instancia de TipoIncidencia con los atributos especificados, excluyendo el identificador único.
	 *
	 * @param descripcion_tipo Descripción del tipo de incidencia.
	 * @param precio_tipo Precio asociado al tipo de incidencia.
	 * @param fecha_fin Fecha de expiración del tipo de incidencia.
	 */
	public TipoIncidencia(String descripcion_tipo, float precio_tipo, Calendar fecha_fin) {
		super();
		this.descripcion_tipo = descripcion_tipo;
		this.precio_tipo = precio_tipo;
		this.fecha_fin = fecha_fin;
	}
	
	
}
