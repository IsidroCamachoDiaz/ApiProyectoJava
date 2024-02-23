package edu.apiProyectoJava.bean;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
/**
 * Clase que representa a un usuario en el sistema.
 * 
 * Esta clase mapea la entidad 'usuarios' de la base de datos.
 * 
 * @author Isidro Camacho Diaz
 * 
 * @param id_usuario Identificador único del usuario.
 * @param nombre Nombre del usuario.
 * @param telefono Número de teléfono del usuario.
 * @param correo Correo electrónico del usuario.
 * @param contrasenia Contraseña del usuario.
 * @param alta Indica si el usuario está activo o no.
 * @param foto Foto del usuario en formato byte array.
 * @param fecha_baja Fecha y hora en que el usuario fue dado de baja en el sistema.
 * @param acceso Acceso asociado al usuario.
 * @param tokens_usuario Lista de tokens asociados al usuario.
 * @param solicitudes_usuario Lista de solicitudes creadas por el usuario.
 * @param incidencias_empleado Lista de incidencias relacionadas con el usuario como empleado.
 */
@Entity
@Table(name="usuarios",schema="personal_datos")
public class Usuario {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario",nullable=false)
	private int id_usuario;
	
	@Column(name="nombre_usuario",nullable=false)
	private String nombre;
	
	@Column(name="telefono_usuario",nullable=false)
	private String telefono;
	
	@Column(name="correo_usuario",nullable=false)
	private String correo;
	
	@Column(name="contrasenia_usuario",nullable=false)
	private String contrasenia;
	
	@Column(name="alta",nullable=false)
	private boolean alta;
	
	@Column(name="foto_usuario")
	private byte[] foto;
	
	@Column(name="fecha_baja")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha_baja;
	
	@ManyToOne
	@JoinColumn(name = "id_acceso")
	private Acceso acceso;
	
	@OneToMany(mappedBy="usuario")
	@JsonIgnoreProperties(value={"usuario"},allowSetters=true)
	private List <Token> tokens_usuario;
	
	
	@OneToMany(mappedBy="cliente",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value={"cliente"},allowSetters=true)
	private List <Solicitud> solicitudes_usuario;
	
	@OneToMany(mappedBy="empleado")
	@JsonIgnoreProperties(value={"empleado"},allowSetters=true)
	private List <Incidencia> incidencias_empleado;
	
	//Geters y Seters
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Calendar getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(Calendar fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public Acceso getAcceso() {
		return acceso;
	}

	public void setAcceso(Acceso acceso) {
		this.acceso = acceso;
	}

	public List<Token> getTokens_usuario() {
		return tokens_usuario;
	}

	public void setTokens_usuario(List<Token> tokens_usuario) {
		this.tokens_usuario = tokens_usuario;
	}

	public List<Solicitud> getSolicitudes_usuario() {
		return solicitudes_usuario;
	}

	public void setSolicitudes_usuario(List<Solicitud> solicitudes_usuario) {
		this.solicitudes_usuario = solicitudes_usuario;
	}

	public List<Incidencia> getIncidencias_empleado() {
		return incidencias_empleado;
	}

	public void setIncidencias_empleado(List<Incidencia> incidencias_empleado) {
		this.incidencias_empleado = incidencias_empleado;
	}
	
	//Constructores
	
	/**
	 * Crea una nueva instancia de Usuario con los atributos especificados.
	 *
	 * @param id_usuario Identificador único del usuario.
	 * @param nombre Nombre del usuario.
	 * @param telefono Número de teléfono del usuario.
	 * @param correo Correo electrónico del usuario.
	 * @param contrasenia Contraseña del usuario.
	 * @param alta Estado de alta del usuario.
	 * @param foto Fotografía del usuario en formato byte[].
	 * @param fecha_baja Fecha de baja del usuario.
	 * @param acceso Acceso asociado al usuario.
	 * @param tokens_usuario Lista de tokens asociados al usuario.
	 * @param solicitudes_usuario Lista de solicitudes asociadas al usuario.
	 * @param incidencias_empleado Lista de incidencias asociadas al usuario como empleado.
	 */
	public Usuario(int id_usuario, String nombre, String telefono, String correo, String contrasenia, boolean alta,
			byte[] foto, Calendar fecha_baja, Acceso acceso, List<Token> tokens_usuario,
			List<Solicitud> solicitudes_usuario, List<Incidencia> incidencias_empleado) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.alta = alta;
		this.foto = foto;
		this.fecha_baja = fecha_baja;
		this.acceso = acceso;
		this.tokens_usuario = tokens_usuario;
		this.solicitudes_usuario = solicitudes_usuario;
		this.incidencias_empleado = incidencias_empleado;
	}

	/**
	 * Crea una nueva instancia de Usuario sin inicializar sus atributos.
	 */
	public Usuario() {
		super();
	}

}
