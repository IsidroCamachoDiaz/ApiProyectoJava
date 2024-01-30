package edu.apiProyectoJava.bean;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
	
	@ManyToOne
	@JoinColumn(name = "id_acceso")
	private Acceso acceso;
	
	@OneToMany(mappedBy="usuario")
	private List <Token> tokens_usuario;
	
	@OneToMany(mappedBy="usuario_solicitud")
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
		
	//Constructores

	public Usuario(int id_usuario, String nombre, String telefono, String correo, String contrasenia, byte[] foto,
			Acceso acceso,boolean alta) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.foto = foto;
		this.acceso = acceso;
		this.alta=alta;
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
