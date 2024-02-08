package edu.apiProyectoJava.bean;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="usuarios",schema="personal_datos")

@JsonIdentityInfo(
	generator=ObjectIdGenerators.PropertyGenerator.class,
	property="id_usuario"
)
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
	private List <Token> tokens_usuario;
	
	
	@OneToMany(mappedBy="cliente",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List <Solicitud> solicitudes_usuario;
	
	@OneToMany(mappedBy="empleado")
	private List <Incidencia> incidencias_empleado;

	//Geters y Seters	
	
	public long getId_usuario() {
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Acceso getAcceso() {
		return acceso;
	}

	public void setAcceso(Acceso acceso) {
		this.acceso = acceso;
	}
	
	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}
	
	public Calendar getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(Calendar fecha_baja) {
		this.fecha_baja = fecha_baja;
	}
		
	//Constructores


	public Usuario(int id_usuario, String nombre, String telefono, String correo, String contrasenia, byte[] foto,
			Acceso acceso,boolean alta,Calendar fecha_baja) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.foto = foto;
		this.acceso = acceso;
		this.alta=alta;
		this.fecha_baja=fecha_baja;
	}

	public Usuario() {
		super();
	}

	public Usuario(String nombre, String telefono, String correo, String contrasenia, byte[] foto) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.foto = foto;
	}	

}
